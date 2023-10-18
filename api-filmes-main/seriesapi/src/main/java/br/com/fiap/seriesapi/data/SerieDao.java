package br.com.fiap.seriesapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.seriesapi.model.Serie;


public class SerieDao {
	
	List<br.com.fiap.seriesapi.model.Serie> lista = new ArrayList<>();
	
	public SerieDao() {
		lista.addAll(List.of(
				new Serie(1L, "Friends", "6 amigos", "http..", true, 10),
				new Serie(2L, "Suits", "Advogado", "http..", true, 8),
				new Serie(3L, "Lost", "morrem", "http..", false, 0)
				
				));
	}

	public List<Serie>findAll(){
		return lista;
	}

	public Serie findById(Long id) {
		//Select from series where id=?
		return lista
			.stream()
			.filter(serie -> serie.id() == id)
			.findFirst() //retornar o id ou
			.orElse(null); //retornar nulo
		
		}

	public void delete(Long id) {
		var serie = findById(id);
		lista.remove(serie);
		System.out.println(lista);
		
	}
}
