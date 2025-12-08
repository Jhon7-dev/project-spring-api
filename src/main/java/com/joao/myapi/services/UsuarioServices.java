package com.joao.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.myapi.domain.Usuario;
import com.joao.myapi.repositories.UsuarioRepository;

@Service
// informa para o spring que é a clçasse de serviços
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
}
