package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);

}
