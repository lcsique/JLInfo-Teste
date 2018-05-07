package com.jlinfo.modeldominio;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class ProdutoBean{
	
	@Id
	private Long id;

	private String descricao;
	private int quantidade_minima;
	private Timestamp data_cadastro = new Timestamp(System.currentTimeMillis());
	private double valor;
	
	public ProdutoBean(Long id, String descricao, int quantidade_minima, double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade_minima = quantidade_minima;
		this.valor = valor;
	}
	
	public ProdutoBean() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade_minima() {
		return quantidade_minima;
	}

	public void setQuantidade_minima(int quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}

	public Timestamp getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Timestamp data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return getDescricao();
	}
}
