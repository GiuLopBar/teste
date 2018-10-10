package br.senai.sp.info.bon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Item {

	@Id
	@Column(name = "Codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Nome_Peca")
	private String nome;
	@Column(name = "Prejuizo_Por_Peca")
	private Double prejuizo;

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", prejuizo=" + prejuizo + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrejuizo() {
		return prejuizo;
	}

	public void setPrejuizo(Double prejuizo) {
		this.prejuizo = prejuizo;
	}

}
