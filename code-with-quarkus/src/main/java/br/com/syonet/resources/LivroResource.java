package br.com.syonet.resources;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.com.syonet.entity.Livro;
import br.com.syonet.service.LivroService;

@Path( "/api/livro" )
public class LivroResource {

	@Inject
	LivroService service;
	
	@GET
	@APIResponses({
			@APIResponse( responseCode = "200",
				description = "Retorno com sucesso da lista de todos os livros" ),
			@APIResponse( responseCode = "400",
				description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	public Response getAllLivros() {
		List< Livro > livros = this.service.getAllLivros();
		return Response.ok( livros ).build();
	}
	
	@GET
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Retorno com sucesso de um livro buscado por Id" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Path( "/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getLivrosById( @PathParam( value = "id" ) Integer id ) {
		Livro livro = this.service.getLivroById( id );
		return Response.ok( livro ).build();
	}
	
	@GET
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Retorno com sucesso de um livro buscado por Título" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Path( "search/{titulo}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getLivroByTitulo( @PathParam( value = "titulo" ) String titulo ) {
		Livro livro = this.service.getLivroByTitulo( titulo );
		return Response.ok( livro ).build();
	}
	
	@POST
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Livro salvo com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response saveLivro ( @Valid Livro livro ) {
		this.service.saveLivro( livro );
		return Response.accepted().build();
	}
	
	@PATCH
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Livro editado com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response updateLivro ( Livro livro ) {
		this.service.updateLivro( livro );
		return Response.accepted().build();
	}
	
	@DELETE
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Livro deletado com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response deleteLivro ( Livro livro ) {
		this.service.deleteLivro( livro );
		return Response.accepted().build();
	}
}
