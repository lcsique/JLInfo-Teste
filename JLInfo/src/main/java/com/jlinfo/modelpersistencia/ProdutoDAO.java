package com.jlinfo.modelpersistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jlinfo.modeldominio.ProdutoBean;

public class ProdutoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("controleEstoque");
		em = emf.createEntityManager();
	}

	public void inserir(ProdutoBean produto) {
		em.getTransaction().begin();
		try {
			em.persist(produto);
			em.getTransaction().commit();
		} finally {
			emf.close();
		}
	}

	public void update(ProdutoBean produto) {
		em.getTransaction().begin();
		try {
			em.merge(produto);
			em.getTransaction().commit();
		} finally {
			emf.close();
		}
	}

	public List<ProdutoBean> listar() {
		em.getTransaction().begin();
		List<ProdutoBean> lista;
		try {
			Query sql = em.createQuery("SELECT p FROM ProdutoBean p");
			lista = sql.getResultList();
		} catch (Exception e) {
			lista = new ArrayList<ProdutoBean>();
		} finally {
			em.close();
		}
		return lista;
	}
}
