package com.jlinfo.beancontroller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jlinfo.modeldominio.*;
import com.jlinfo.modelpersistencia.*;

@ManagedBean(name = "estoque")
@RequestScoped
public class BeanController {
	private List<MovEstoqueBean> listaE = new ArrayList<MovEstoqueBean>();
	private String escolha;
	MovEstoqueBean mb = new MovEstoqueBean();
	ProdutoBean pb = new ProdutoBean();
	
	public List<MovEstoqueBean> getListaCresc() {
		MovEstoqueDAO md = new MovEstoqueDAO();
		this.listaE = md.listarCresc();
		return listaE;
	}

	public MovEstoqueBean getEstoque(Long id) {
		MovEstoqueDAO md = new MovEstoqueDAO();
		this.mb = (MovEstoqueBean) md.consultarPorId(id);
		return mb;
	}
	
	public ProdutoBean getProduto(String desc) {
		ProdutoDAO pd = new ProdutoDAO();
		this.pb = (ProdutoBean) pd.consultarPorDescricao(desc);
		return pb;
	}
	
	public String Procura() {
		return "Pesquisa";
	}
	

	public String getEscolha() {
		return escolha;
	}

	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}
}
