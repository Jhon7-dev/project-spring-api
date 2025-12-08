package com.joao.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joao.myapi.domain.Usuario;
import com.joao.myapi.repositories.UsuarioRepository;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner{

	@Autowired
	// Ele cria uma classe do usuario repository
	private UsuarioRepository usuarioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	//Instanciação automática da nossa base de dados
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "João Victor", "joao", "123");
		// o ID, o próprio jpa cria. por isso é nulo
		Usuario u2 = new Usuario(null, "gustavo", "gtv", "323");
		Usuario u3 = new Usuario(null, "ozzy", "ozzy", "1706");
		Usuario u4 = new Usuario(null, "bruna fernanda", "bruna", "1707");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}

}
