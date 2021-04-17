package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.model.Usuario;
import com.test.repo.IUsuarioRepo;

@SpringBootTest
class DemoWeb2ApplicationTests {

	@Autowired
	private IUsuarioRepo usuRepo;	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void crearUsuario() {
		Usuario us = new Usuario();
		us.setNombre("Rodrigo2");
		us.setClave(encoder.encode("1234"));
		
		Usuario retorno =usuRepo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
