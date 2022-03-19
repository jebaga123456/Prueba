package com.prueba.provider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "HOLIDAY")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "HOLIDAY", schema = "dbo")
public class Holiday  implements Serializable {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private int id;
	    
	    @Column(name = "extra")
	    private String extra;
	    
	    @Column(name = "description")
	    private String title;
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_date", nullable = false,
	            updatable = false)
	    private Date createDate;


}
