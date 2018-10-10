package br.senai.sp.info.bon.dao.jpa;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.bon.dao.UsuarioDAO;
import br.senai.sp.info.bon.model.Usuario;

@Repository("UsuarioDAO")
public class UsuarioJPA extends AbstractJPA<Usuario> implements UsuarioDAO {

	@Override
	public Usuario buscarPorEmailESenha(String email, String senha) {
		List<Usuario> users =  buscarPorCampos(new HashMap<String, Object>(){
			{
				put("email", email);
				put("senha", senha);
			}
		});
		
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	
	@Override
	public Usuario buscarPorSenha(String senha) {
		List<Usuario> users =  buscarPorCampos(new HashMap<String, Object>(){
			{
				
				put("senha", senha);
			}
		});
		
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		List<Usuario> users =  buscarPorCampos(new HashMap<String, Object>(){
			{
				put("email", email);
			}
		});
		
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}

	@Override
	public String getEntityName() {
		return "Usuario";
	}

}
