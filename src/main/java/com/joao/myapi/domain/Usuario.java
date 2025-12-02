package com.joao.myapi.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

/* --> a notação Entity é para informar para o JPA que essa classe é uma entidade e que ele pode criar para ela  uma tabela chamada Usuario na nossa base de dados*/
/* posso também passsar o nome que eu desejo para ela colocar na base de dados*/

@Entity
public class Usuario implements Serializable {
	/*
	 * Serializable, ele pega uma instância da nossa classe e cria uma sequência de
	 * baixo da instância que poderá ser trafegados em rede armazenadas em arquivos
	 * de dados do outro lado e recuperar na memória
	 */
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L; 
	/* esssa notação Id é para informar ao JPA que essa é uma chave primária   */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/* Quero informar que ele não vai poder ser vazio */
	@NotEmpty(message = "Campo NOME é mandatório")
	@Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	private String nome;
	@NotEmpty(message = "Campo LOGIN é mandatório")
	@Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	private String login;
	@NotEmpty(message = "Campo SENHA é mandatório")
	@Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	private String senha;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String nome, String login, String senha) {

		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
