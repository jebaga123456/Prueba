package com.prueba.provider.util;

import java.io.IOException;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTUtil implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("deprecation")
	
	public static Boolean validateToken(String token, String publicKeyStr) {
		RSAKey key;
		log.info("token validateToken : " + token );
		if (token != null) {
			try {
				
				key = (RSAKey) getPublicKey(publicKeyStr);
				
				JWT.require(Algorithm.RSA256(key))
						// .withSubject(subject)
						.build().verify(token);
				return true;				
			} catch (TokenExpiredException e) {				
				log.error("token is expirate");
				return false;				
			} catch (JWTDecodeException e) {				
				log.error("error validateToken : "+ e.getMessage());				
			}
		}
		return false;
	}

	private static PublicKey getPublicKey(String publicKeyStr) {		        
        		String publicKeyContent = publicKeyStr.replaceAll("\\n", "") 
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");        
        Base64 b64 = new Base64();
        byte [] decoded = b64.decode(publicKeyContent);        
        PublicKey publicKey = null;
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            EncodedKeySpec keySpec = new X509EncodedKeySpec (decoded);
            publicKey = kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
        	log.error("Could not reconstruct the public key, the given algorithm could not be found.");
        } catch (InvalidKeySpecException e) {
        	log.error("Could not construct the public key");
        }
        return publicKey;		
	}
	
	public static String generateToken(String issuer ,List<String> roles, String privateKeyStr) {
		String[] claimRoles = new String[roles.size()];				
		for (String role : roles) {
			claimRoles[roles.indexOf(role)] = role;
		}
		return doGenerateToken(issuer,claimRoles, privateKeyStr);
		
	}
	
	@SuppressWarnings("deprecation")
	private static String doGenerateToken(String issuer ,String[] claims, String privateKeyStr) {
		long expirationTimeLong = TimeUnit.MILLISECONDS.convert(Long.parseLong(Constant.TOKEN_DURATION_TIME),
				TimeUnit.MINUTES);
		
		RSAKey key;
		
		
		////TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
		
		
		final Date createdDate = new Date();
		
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);
		key = (RSAKey) getPrivateKey(privateKeyStr);		
		Algorithm algorithm = Algorithm.RSA256(key);
		return JWT.create()
				.withSubject(issuer)
				.withIssuedAt(createdDate)
				.withExpiresAt(expirationDate)
				.withArrayClaim("rol", claims)
				.sign(algorithm);
	}
	
	@SuppressWarnings("deprecation")
	public static String generateJWT(String did, String aud, String role, String privateKeyStr) {

		long expirationTimeLong = TimeUnit.MILLISECONDS.convert(Long.parseLong(Constant.TOKEN_DURATION_TIME),
				TimeUnit.DAYS);
		RSAKey key;
		
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);

		key = (RSAKey) getPrivateKey(privateKeyStr);
						
		String[] roles  = {role};
		Algorithm algorithm = Algorithm.RSA256(key);
		return JWT.create().withSubject(did).withAudience(aud).withIssuedAt(createdDate).withExpiresAt(expirationDate).
				withArrayClaim("roles",roles )
				.sign(algorithm);

		
	}

	private static PrivateKey getPrivateKey(String privateKeyStr) {

		String privateKeyContent = privateKeyStr.replaceAll("\\n", "")
				.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");

		Base64 b64 = new Base64();
		byte[] decoded = b64.decode(privateKeyContent);
		PrivateKey privateKey = null;
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
			privateKey = kf.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			log.error("Could not reconstruct the private key, the given algorithm could not be found.");
		} catch (InvalidKeySpecException e) {
			log.error("Could not reconstruct the private key");
		}
		
		
		return privateKey;
	}

	@SuppressWarnings("deprecation")
	
	public static String getUsernameFromToken(String token , String  publicKeyStr) {
	
		RSAKey key;
		
				
		if (token != null) {
		
			String user = null;
			try {
				key = (RSAKey) getPublicKey(publicKeyStr);
				DecodedJWT jwt = JWT.require(Algorithm.RSA256(key))
						// .withSubject(subject)
						.build().verify(token);
				user = jwt.getSubject();
				return user;
			} catch (JWTDecodeException e) {
				log.error("Decode getUsernameFromToken : " + e.getMessage());
				
			}
		}
		return "";
	}
}
