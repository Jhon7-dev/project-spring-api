package com.joao.myapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.myapi.domain.Usuario;
import com.joao.myapi.services.UsuarioServices;

@RestController 
// informa para o spring que é um controlador rest
@RequestMapping(value = "/usuarios")
//ResquestMapping, adiciona um endpoint
public class UsuarioResource {
	// primeiro método a implementar
	//FindById (busca o usuário pelo ID)
	@Autowired
	private UsuarioServices service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario>findById(@PathVariable Integer id){
		Usuario obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	//Listar p Usuario
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
