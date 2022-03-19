package com.prueba.provider.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.provider.model.Holiday;


public interface DataRepository extends JpaRepository<Holiday, String> {
		
}
