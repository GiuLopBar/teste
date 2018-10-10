package br.senai.sp.info.bon.dao;

import org.springframework.transaction.annotation.Transactional;

import br.senai.sp.info.bon.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{

	@Transactional
	public Usuario buscarPorEmailESenha(String email, String senha);
	
	@Transactional
	public Usuario buscarPorEmail(String email);
	
	@Transactional
	public Usuario buscarPorSenha(String senha);
}
