package com.okan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okan.model.Bayi;

public interface BayiRepository extends JpaRepository<Bayi, Integer>{

	Bayi findByName(String name);
}
