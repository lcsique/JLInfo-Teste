package com.jlinfo.modelpersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jlinfo.modeldominio.MovEstoqueBean;

public class MovEstoqueDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	public MovEstoqueDAO() {
		emf = Persistence.createEntityManagerFactory("controleEstoque");
		em = emf.createEntityManager();
	}

	public void inserir(MovEstoqueBean movestoque) {
		em.getTransaction().begin();
		try {
			em.persist(movestoque);
			em.getTransaction().commit();
		} finally {
			emf.close();
		}
	}
}
