package com.jlinfo.modeldominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_movimento_estoque")
public class MovEstoqueBean {
	@Id
	private Long id;
	
	@ManyToOne
	private ProdutoBean produto;
	
	private Timestamp data_movimentacao = new Timestamp(System.currentTimeMillis());
	private int quantidade;
	
	@Column(name="tipo_movimentacao")
	@Enumerated(EnumType.STRING)
	private Tipo_movimentacao tm;
	
	public MovEstoqueBean(Long id, ProdutoBean produto, int quantidade, Tipo_movimentacao tm) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.tm = tm;
	}
	
	public MovEstoqueBean() {};
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public ProdutoBean getProduto() {
		return produto;
	}

	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}

	public Timestamp getData_movimentacao() {
		return data_movimentacao;
	}

	public void setData_movimentacao(Timestamp data_movimentacao) {
		this.data_movimentacao = data_movimentacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Tipo_movimentacao getTm() {
		return tm;
	}

	public void setTm(Tipo_movimentacao tm) {
		this.tm = tm;
	}
}
