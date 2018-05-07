package com.jlinfo.modelpersistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.jlinfo.modeldominio.MovEstoqueBean;
import com.jlinfo.modeldominio.ProdutoBean;

public class ProdutoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("controleEstoque");
		em = emf.createEntityManager();
	}

	public void inserir(ProdutoBean produto) throws SQLException {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		emf.close();
	}

	public void update(ProdutoBean produto) throws SQLException {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		emf.close();
	}

	public List<ProdutoBean> listar(String desc) {
		em.getTransaction().begin();
		List<ProdutoBean> lista;
		try {
		Query sql = em.createQuery("SELECT p FROM ProdutoBean p");
			lista = sql.getResultList();
		} catch (Exception e) {
			lista = new ArrayList<ProdutoBean>();
		} finally {
			emf.close();
		}
		return lista;
	}
	
	public Object consultarPorDescricao(String descricao) {
		em.getTransaction().begin();
		Object pb = new ProdutoBean();
		Query sql = em.createQuery("SELECT p FROM ProdutoBean p WHERE descricao = ?1")
				.setParameter(1, descricao);
		pb = sql.getSingleResult();
		emf.close();
		return pb;
	}
}
