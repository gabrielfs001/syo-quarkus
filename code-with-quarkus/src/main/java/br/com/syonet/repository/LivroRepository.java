package br.com.syonet.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.syonet.entity.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class LivroRepository implements ILivroRepository, PanacheRepositoryBase<Livro, Integer>{

	@Override
	@Transactional
	public void saveLivro(Livro livro) {
		this.persist(livro);
	}

	@Override
	public void updateLivro(Livro livro) {
		this.findByIdOptional( livro.getId() ).ifPresent( persistedLivro -> {
			persistedLivro.setTitulo( livro.getTitulo() );
			persistedLivro.setTituloOriginal( livro.getTituloOriginal() );
			persistedLivro.setNumeroEdicao( livro.getNumeroEdicao() );
			persistedLivro.setNumeroPaginas( livro.getNumeroPaginas() );
			persistedLivro.setEditora( livro.getEditora() );
			persistedLivro.setAutores( livro.getAutores() );
			this.persist(persistedLivro);
		});
	}

	@Override
	public List<Livro> getAllLivros() {
		return this.findAll().list();
	}

	@Override
	public Livro getLivroById(Integer id) {
		return this.findById( id );
	}

	@Override
	public Livro getLivroByTitulo(String titulo) {
		return this.find("titulo", titulo).firstResult();
	}

	@Override
	public void deleteLivro(Livro livro) {
		this.findByIdOptional( livro.getId() ).ifPresent(persistedLivro -> {
			this.delete(persistedLivro);
		});
	}

}
