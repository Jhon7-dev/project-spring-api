package com.joao.myapi.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
	}

	public Usuario create(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ResponseEntity<Object> delete(Integer id) {
		findById(id);
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
