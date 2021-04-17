package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{ 

}
