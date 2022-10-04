package br.com.syonet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.syonet.entidade.Livro;

public class LivroDAO {
	public void salva ( Livro livro ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-banco");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(livro);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public Livro buscaPorId ( Integer id ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-banco");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Livro livro1 = entityManager.find(Livro.class, id);
		
		entityManager.close();
		entityManagerFactory.close();
		return livro1;
	}
	
	public Livro buscaPorAutor ( String nomeAutor ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-banco");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//entityManager.getTransaction().begin();

		Livro livro2 = entityManager.find(Livro.class, nomeAutor);
		
		entityManager.close();
		entityManagerFactory.close();
		return livro2;
	}
}
