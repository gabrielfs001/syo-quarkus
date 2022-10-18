package br.com.syonet.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.syonet.entity.Autor;
import br.com.syonet.repository.IAutorRepository;

@ApplicationScoped
public class AutorService {

	@Inject
	IAutorRepository repository;
	
	public void saveAutor( Autor autor ) {
		this.repository.saveAutor( autor );
	}
	
	public void updateAutor( Autor autor ) {
		this.repository.updateAutor( autor );
	}
	
	public List< Autor > getAllAutores() {
		return this.repository.getAllAutores();
	}
	
	public Autor getAutorById( Integer id ) {
		return this.repository.getAutorById(id);
	}
	
	public Autor getAutorByName( String name ) {
		return this.repository.getAutorByName(name);
	}
	
	public void deleteAutor( Autor autor ) {
		this.repository.deleteAutor(autor);
	}
}
