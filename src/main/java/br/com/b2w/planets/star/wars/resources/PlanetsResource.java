package br.com.b2w.planets.star.wars.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.planets.star.wars.domain.Planet;

@RestController
@RequestMapping(value="/planets")
public class PlanetsResource {

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<Planet>> findAll(){
		Planet p1 = new Planet("1", "Tatooine", "arido", "desértico");
		Planet p2 = new Planet("2", "Alderaan", "temperado", "frio de montanha");
		List<Planet> list = new ArrayList<Planet>();
		list.addAll(Arrays.asList(p1,p2));
		
		return ResponseEntity.ok().body(list);
	
	}
}
