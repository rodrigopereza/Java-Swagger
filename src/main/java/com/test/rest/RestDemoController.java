package com.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Persona;
import com.test.repo.IPersonaRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/personas")
@Api(tags = { "Persona" }, description = "REST APIs CRUD Personas")
public class RestDemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	
	@ApiOperation(value = "Listar Personas", 
				 produces = "application/json",
    			 notes = "Lista todas las Personas del Modelo de Datos",
    			 tags = { "Persona" })
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente",
            			 response = Persona.class, 
            			 responseContainer = "List" ),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping
	public List <Persona> listar(){
		return repo.findAll();
	}
	
	
	@ApiOperation(value = "Insertar Persona",
		  	  produces = "application/json",
		  	  notes = "Servicio para crear una nueva persona",
		  	  tags = { "Persona" })
	@PostMapping
	public void insertar(@ApiParam(value = "Datos de la Persona", 
						type = "Persona", 
						required = true, 
						defaultValue = "null")
						@RequestBody Persona per) {
		repo.save(per); 
	}
	
	@ApiOperation(value = "Actualizar Persona",
			  	  produces = "application/json",
			  	  notes = "Modifica los datos de un uusario apartir del objeto del usaurio",
			  	  tags = { "Persona" })
	@PutMapping
	public void modificar(@ApiParam(value = "Datos de la Persona", 
									type = "Persona", 
									required = true, 
									defaultValue = "null")
						 @RequestBody Persona per) {
		repo.save(per); 
	}
	
	@ApiOperation(value = "Elimina una Persona",
				  produces = "application/json",
		    	  notes = "Elimina un usuario apartir del Id",
		    	  tags = { "Usuario" })
	@DeleteMapping(value = "{id}")
	public void eliminar(@ApiParam(	value = "Id de la persona a eliminar", 
									type = "Integer", 
									required = true, 
									defaultValue = "0")  
						 @PathVariable("id") Integer Id) {
		repo.deleteById(Id); 
	}

}
