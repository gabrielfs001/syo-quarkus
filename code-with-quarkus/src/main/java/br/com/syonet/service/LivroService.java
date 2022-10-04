package br.com.syonet.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.syonet.entity.Livro;
import br.com.syonet.repository.ILivroRepository;

@ApplicationScoped
public class LivroService {
	
	@Inject
	ILivroRepository repository;
	
	public void saveLivro ( Livro livro ) {
		this.repository.saveLivro( livro );
	}
	
	public void updateLivro ( Livro livro ) {
		this.repository.updateLivro(livro);
	}
	
	public List< Livro > getAllLivros() {
		return this.repository.getAllLivros();
	}
	
	public Livro getLivroById(Integer id) {
		return this.repository.getLivroById(id);
	}
	
	public Livro getLivroByTitulo( String titulo ) {
		return this.repository.getLivroByTitulo(titulo);
	}
	
	public void deleteLivro( Livro livro ) {
		this.repository.deleteLivro(livro);
	}
}
