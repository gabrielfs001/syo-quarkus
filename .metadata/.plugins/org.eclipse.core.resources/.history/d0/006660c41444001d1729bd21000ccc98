package br.com.syonet.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.syonet.entity.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AutorRepository implements IAutorRepository, PanacheRepositoryBase<Autor, Integer>{

	@Override
	@Transactional
	public void saveAutor(Autor autor) {
		this.persist(autor);
	}

	@Override
	@Transactional
	public void updateAutor(Autor autor) {
		this.findByIdOptional( autor.getId() ).ifPresent( persistedAutor -> {
			persistedAutor.setNome( autor.getNome() );
			persistedAutor.setSobrenome( autor.getSobrenome() );
			persistedAutor.setLocalNascimento( autor.getLocalNascimento() );
			persistedAutor.setDataNascimento( autor.getDataNascimento() );
			this.persist( persistedAutor );
		});
	}
	
	@Override
	public List<Autor> getAllAutores() {
		return this.findAll().list();
	}

	@Override
	public Autor getById(Integer id) {
		return this.findById( id );
	}

	@Override
	public Autor getByName(String nome) {
		return this.find("nome", nome).firstResult();
	}

	@Override
	@Transactional
	public void deleteAutor(Autor autor) {
		this.findByIdOptional( autor.getId() ).ifPresent( persistedAutor -> {
			this.delete(persistedAutor);
		});
	}
	
	



}
