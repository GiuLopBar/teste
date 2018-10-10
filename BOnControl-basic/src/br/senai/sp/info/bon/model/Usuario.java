package br.senai.sp.info.bon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.DigestUtils;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "Codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Login")
	private String email; 
	@Column(name = "Senha")
	private String senha;
	
	public void hashearSenha() {
		this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes());
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 
	
	
	
}
