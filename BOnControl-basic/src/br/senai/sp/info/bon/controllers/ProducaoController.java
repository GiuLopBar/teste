package br.senai.sp.info.bon.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.info.bon.core.SessionUtils;
import br.senai.sp.info.bon.dao.ItemDAO;
import br.senai.sp.info.bon.dao.ProducaoDAO;
import br.senai.sp.info.bon.exceptions.ValidacaoException;
import br.senai.sp.info.bon.model.Item;
import br.senai.sp.info.bon.model.Producao;

@Controller
@RequestMapping("/app")
public class ProducaoController {
	
	@Autowired
	private ProducaoDAO producaoDAO; 
	
	@Autowired
	private ItemDAO itemDAO; 
	
	@Autowired
	private SessionUtils sessionUtils;
	
	@GetMapping({"/producao/cadastro"})
	public String abriFormProducao(Model model) {
		model.addAttribute("itens", itemDAO.buscarTodos());
		model.addAttribute("producao", new Producao());
		
		return "producao/form";
	}
	
	@PostMapping("/producao/salvar")
	public String salvar(@Valid Producao producao, BindingResult brProducao, Model model) throws ValidacaoException {		
		//Checa os erros de campos
			if (brProducao.hasErrors()) {
			brProducao.addError(new FieldError("producao", "itensReprovados", "Campos inválidos"));
			model.addAttribute("itens", itemDAO.buscarTodos());
			model.addAttribute("producao", new Producao());

			return "producao/form";
			}
			
			Long produzidos = producao.getItensAprovados() -  producao.getItensReprovados(); 
			producao.setItensProduzidos(produzidos);
			
			Double prejuizo = producao.getItensReprovados() * itemDAO.buscar(producao.getItem().getId()).getPrejuizo();
			
			if(producao.getItensReprovados() > producao.getItensAprovados()) {
				brProducao.addError(new FieldError("producao", "itensReprovados", "Os itens reprovados não podem ser maiores que os aprovados"));
			
			}
			
			producao.setPrejuizoEstimado(prejuizo);
			
			producaoDAO.inserir(producao);
		
		return "redirect:/app/producao/cadastro";
	}
	

}
