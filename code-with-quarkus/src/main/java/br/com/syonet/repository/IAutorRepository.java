package br.com.syonet.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.syonet.entity.Autor;

@ApplicationScoped
public interface IAutorRepository {
	
	void saveAutor( Autor autor );
	
	void updateAutor( Autor autor );
	
	List < Autor > getAllAutores();
	
	Autor getAutorById( Integer id );
	
	Autor getAutorByName ( String nome );
	
	void deleteAutor ( Autor autor );
}
