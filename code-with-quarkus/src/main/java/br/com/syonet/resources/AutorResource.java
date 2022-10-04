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

import br.com.syonet.entity.Autor;
import br.com.syonet.service.AutorService;

@Path( "/api/autor" )
public class AutorResource {

	@Inject
	AutorService service;
	
	@GET
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Retorno com sucesso da lista de todos os autores" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	public Response getAllAutores() {
		List< Autor > autores = this.service.getAllAutores();
		return Response.ok( autores ).build();
	}
	
	@GET
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Retorno com sucesso de um autor buscado por Id" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Path( "/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getAllAutores( @PathParam( value = "id" ) Integer id ) {
		Autor autor = this.service.getAutorById( id );
		return Response.ok( autor ).build();
	}
	
	@GET
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Retorno com sucesso de um autor buscado por nome" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Path( "/{nome}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getAllAutores( @PathParam( value = "nome" ) String nome ) {
		Autor autor = this.service.getByName( nome );
		return Response.ok( autor ).build();
	}
	
	@POST
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Autor adicionado com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response saveAutor ( @Valid Autor autor ) {
		this.service.saveAutor( autor );
		return Response.accepted().build();
	}
	
	@PATCH
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Autor editado com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response updateAutor ( Autor autor ) {
		this.service.updateAutor( autor );
		return Response.accepted().build();
	}
	
	@DELETE
	@APIResponses({
		@APIResponse( responseCode = "200",
			description = "Autor deletado com sucesso" ),
		@APIResponse( responseCode = "400",
			description = "Em casos de erro genérico" )})
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response deleteAutor ( Autor autor ) {
		this.service.deleteAutor( autor );
		return Response.accepted().build();
	}
}

