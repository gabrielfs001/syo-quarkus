package br.com.syonet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.syonet.entidade.Autor;

public class AutorDAO {
	public void salva ( Autor autor ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-banco");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(autor);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
