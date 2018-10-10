package br.senai.sp.info.bon.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.senai.sp.info.bon.core.SessionUtils;
import br.senai.sp.info.bon.dao.UsuarioDAO;
import br.senai.sp.info.bon.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO; 
	
	@Autowired
	private SessionUtils sessionUtils;
	
	@GetMapping(value = {"/", ""})
	public String abrirLogin(Model model) {
	
			model.addAttribute("usuario", new Usuario());
			return "index";
		
	}
	
	@PostMapping({"/usuario/autenticar"})
	public String autenticar(@Valid Usuario usuario, BindingResult brUsuario) {
		
		//Se houver erros no usuario, reabre o index
		if(brUsuario.hasFieldErrors("email") || brUsuario.hasFieldErrors("senha")) {
			return "index";
		}
		
		//hasheia a senha inserida para buscar no banco de dados
		usuario.hashearSenha();
		Usuario usuarioBuscado = usuarioDAO.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

		//Aplica o usuário na sessão e abre a página inicial
		sessionUtils.setUsuarioLogado(usuarioBuscado);
		
		return "redirect:/app/producao/cadastro";
	}
	
	@GetMapping({"/sair"})
	public String logout() {
		sessionUtils.invalidarSessao();
		
		return "redirect:/";
	}

}
