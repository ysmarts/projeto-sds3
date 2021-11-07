package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Mapeamento do paradigma orientado a objetos(java) -> paradigma objeto relacional do nosso banco de dados
@Table(name = "tb_sellers") //Nome da tabela do banco
public class Seller {
	
	@Id //Irá indicar qual atributo é chave primária para o banco
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Informar ao banco que o Id será auto incrementavel
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "seller") //Um para muitos -> Um Seller pode ter muitas Sales. mappedBy -> linha 27 Sale
	private List<Sale> sales = new ArrayList<>();
	
	public Seller() {	
	}

	public Seller(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sale> getSales() {
		return sales;
		//Coleção só colocamos o método Get
	}
}
