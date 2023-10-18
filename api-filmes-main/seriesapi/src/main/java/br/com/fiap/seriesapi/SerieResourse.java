package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;
import br.com.fiap.seriesapi.service.SerieService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//caminho que a pessoa vai acessar
@Path("serie")

public class SerieResourse {
	
	private SerieService service = new SerieService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Serie> index() {
		return service.findAll();
	}
	
	@GET
	@Path("{id}") //serie/{id} -> parametro de path
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam ("id")Long id) {
		//System.out.println("Encontrado");
		var serie =  service.findById(id);
		if(serie == null) {
			return Response.status(Response
					.Status.NOT_FOUND)
					.build();//build - construir a resposta
		}
		return Response.ok(serie).build(); //
	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") Long id) {
		//System.out.println("Apagar serie com o id " +id);
		var serie = service.findById(id);
		
		if(serie == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		
		service.delete(id);
		return Response.noContent().build();	
}
	
		
	
	//query param -> serie?busca=test&ordenacao=cres
	
	//fipe/marca/ford/modelo/ka/ano/1998
}
