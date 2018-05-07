package com.jlinfo.modelpersistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jlinfo.modeldominio.MovEstoqueBean;
import com.jlinfo.modeldominio.ProdutoBean;

public class MovEstoqueDAO{
	private EntityManagerFactory emf;
	private EntityManager em;

	public MovEstoqueDAO() {
		emf = Persistence.createEntityManagerFactory("controleEstoque");
		em = emf.createEntityManager();
	}

	public void inserir(MovEstoqueBean movestoque) throws SQLException {
		em.getTransaction().begin();
		em.persist(movestoque);
		em.getTransaction().commit();
		emf.close();
	}
	
	public List<MovEstoqueBean> listarCresc() {
		em.getTransaction().begin();
		List<MovEstoqueBean> lista;
		try {
			Query sql = em.createQuery("SELECT e FROM MovEstoqueBean e WHERE tipo_movimentacao = 'ENTRADA' ORDER BY quantidade ASC");
			lista = sql.getResultList();
		} catch (Exception e) {
			lista = new ArrayList<MovEstoqueBean>();
		} finally {
			emf.close();
		}
		return lista;
	}
	
	public Object consultarPorId(Long id) {
		em.getTransaction().begin();
		Object mb = new ProdutoBean();
		Query sql = em.createQuery("SELECT e FROM MovEstoqueBean e WHERE produto_id = ?1")
				.setParameter(1, id);
		mb = sql.getSingleResult();
		emf.close();
		return mb;
	}
}
