package com.joao.myapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joao.myapi.domain.Usuario;
import com.joao.myapi.services.UsuarioServices;

@RestController
// informa para o spring que é um controlador rest

@RequestMapping(value = "/usuarios")
//ResquestMapping, adiciona um endpoint
public class UsuarioResource {
	// primeiro método a implementar
	// FindById (busca o usuário pelo ID)
	@Autowired
	private UsuarioServices service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// Listar p Usuario
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PutMapping(value = "/{id}")
	// para eu atualizar o usuário, eu preciso do Id do usuário para buscar com as
	// info desatualizadas e precisamos de um obejto tipo usuário com as informações
	// atualizadas
	public ResponseEntity<Usuario> ipdate(@PathVariable Integer id, @RequestBody Usuario obj) {
		Usuario newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	@PostMapping
	// quando o endpoint "/usuarios" receber a requisição do tipo post, ele vai buscar pelo metodo create, mas eu tenho que receber um novo usuário
	public ResponseEntity<Usuario>create(@RequestBody Usuario obj){
		Usuario newObj = service.create(obj);
		// quando eu crio um novo objeto via endpoint, tenho que passar para o usuario a URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		return ResponseEntity.noContent().build();
	}
}
