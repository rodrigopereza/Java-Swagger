package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PersonaModel", description="Modelo de datos de una Persona")
@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPersona;
	
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@ApiModelProperty(notes = "Identificador único de la Persona", 
            		  example = "1", required = false, position = 0)
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	@ApiModelProperty(notes = "Nombre de la Persona", 
            		  example = "Camilo Torres", required = true, position = 1)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
