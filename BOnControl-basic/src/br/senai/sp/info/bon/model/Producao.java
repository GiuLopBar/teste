package br.senai.sp.info.bon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "producao")
public class Producao {

	@Id
	@Column(name = "Codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "Codigo_item")
	private Item item;

	@Column(name = "Data")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@Column(name = "Itens_Aprovados")
	private Long itensAprovados;

	@Column(name = "Itens_Reprovados")
	private Long itensReprovados;

	@Column(name = "Itens_Produzidos")
	private Long itensProduzidos;

	@Column(name = "Prejuizo_Estimado")
	private Double prejuizoEstimado;

	@Column(name = "Usuario_Representante")
	private String email;

	@Override
	public String toString() {
		return "Producao [id=" + id + ", item=" + item + ", data=" + data + ", itensAprovados=" + itensAprovados
				+ ", itensReprovados=" + itensReprovados + ", itensProduzidos=" + itensProduzidos
				+ ", prejuizoEstimado=" + prejuizoEstimado + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getItensAprovados() {
		return itensAprovados;
	}

	public void setItensAprovados(Long itensAprovados) {
		this.itensAprovados = itensAprovados;
	}

	public Long getItensReprovados() {
		return itensReprovados;
	}

	public void setItensReprovados(Long itensReprovados) {
		this.itensReprovados = itensReprovados;
	}

	public Long getItensProduzidos() {
		return itensProduzidos;
	}

	public void setItensProduzidos(Long itensProduzidos) {
		this.itensProduzidos = itensProduzidos;
	}

	public Double getPrejuizoEstimado() {
		return prejuizoEstimado;
	}

	public void setPrejuizoEstimado(Double prejuizoEstimado) {
		this.prejuizoEstimado = prejuizoEstimado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
