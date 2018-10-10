package br.senai.sp.info.bon.dao.jpa;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.bon.dao.ProducaoDAO;
import br.senai.sp.info.bon.model.Producao;

@Repository("ProducaoDAO")
public class ProducaoJPA extends AbstractJPA<Producao> implements ProducaoDAO{

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return "Producao";
	}

}
