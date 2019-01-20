package br.com.b2w.planets.star.wars.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.b2w.planets.star.wars.domain.Planet;
import br.com.b2w.planets.star.wars.dto.PlanetDTO;
import br.com.b2w.planets.star.wars.service.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

	@Autowired
	PlanetService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<PlanetDTO>> findAll(){
		
		List<Planet> list = service.findAll();
		List<PlanetDTO> listDTO = list.stream().map(data -> new PlanetDTO(data)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ResponseEntity<PlanetDTO> findById(@PathVariable String id){
		Planet planet = service.findById(id);
		return ResponseEntity.ok().body(new PlanetDTO(planet));
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PlanetDTO objDto){
		Planet planet = service.fromDTO(objDto);
		planet = service.insert(planet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planet.getId()).toUri();
		return ResponseEntity.created(uri).build();	
		
	}
	
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public ResponseEntity<PlanetDTO> deleteById(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PlanetDTO objDto, @PathVariable String id){
		Planet planet = service.fromDTO(objDto);
		planet.setId(id);
		planet = service.update(planet);
		return ResponseEntity.noContent().build();
	}
}
