package com.joao.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.myapi.domain.Usuario;
import com.joao.myapi.repositories.UsuarioRepository;
import com.joao.myapi.services.exception.ObjectNotFoundException;

@Service
// informa para o spring que é a clçasse de serviços
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		
		return repository.findAll();
	}
	
}
