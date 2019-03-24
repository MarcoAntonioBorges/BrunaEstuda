package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.ProdutoTO;
import br.com.fiap.bo.ProdutoBO;

@Path("/produto")
public class ProdutoResource {
	
	private ProdutoBO produto = ProdutoBO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listar(){
		return produto.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ProdutoTO buscar(@PathParam("id") int codigo) {
		return produto.consultaProduto(codigo);
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		produto.remover(codigo);
	}
	
	/*
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProdutoTO produtoTO, @PathParam("id") int codigo) {
		produtoTO.setCodigo(codigo);
		produto.atualizar(produtoTO);
		return Response.ok().build();
	}
	*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produtoTO, @Context UriInfo uriInfo) {
		produto.cadastrar(produtoTO);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produtoTO.getCodigo()));
		return Response.created(builder.build()).build();
	}
}
