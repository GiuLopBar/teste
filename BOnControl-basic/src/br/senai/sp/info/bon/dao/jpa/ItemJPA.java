package br.senai.sp.info.bon.dao.jpa;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.bon.dao.ItemDAO;
import br.senai.sp.info.bon.model.Item;

@Repository("ItemDAO")
public class ItemJPA extends AbstractJPA<Item> implements ItemDAO{

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return "Item";
	}

}
