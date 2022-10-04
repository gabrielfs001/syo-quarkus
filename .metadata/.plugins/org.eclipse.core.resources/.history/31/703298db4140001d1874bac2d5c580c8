package br.com.syonet.business;

import java.util.Objects;

import br.com.syonet.dao.AutorDAO;
import br.com.syonet.entidade.Autor;

public class AutorBusiness {
	private AutorDAO dao = new AutorDAO();
	
	public void salva ( Autor registro ) {
		if ( Objects.isNull(registro) ) {
			throw new NullPointerException ("Registro está nulo!");
		}
		this.dao.salva(registro);
	}
}
