package br.com.b2w.planets.star.wars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.planets.star.wars.domain.Planet;
import br.com.b2w.planets.star.wars.service.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@Autowired
	PlanetService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<Planet>> findAll(){
		
		List<Planet> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
}
