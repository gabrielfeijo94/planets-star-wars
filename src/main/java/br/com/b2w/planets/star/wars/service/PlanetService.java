package br.com.b2w.planets.star.wars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.planets.star.wars.domain.Planet;
import br.com.b2w.planets.star.wars.dto.PlanetDTO;
import br.com.b2w.planets.star.wars.repository.PlanetRepository;
import br.com.b2w.planets.star.wars.service.exception.ObjectNotFoundException;

@Service
public class PlanetService {

	@Autowired
	PlanetRepository repo;
	
	public List<Planet> findAll(){
		return repo.findAll();
	}
	
	public Planet findById(String id) {
		Optional<Planet> planet = repo.findById(id);
		return planet.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Planet insert(Planet planet) {
		return repo.insert(planet);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Planet update(Planet planet) {
		Planet newPlanet = findById(planet.getId());
		updateData(newPlanet, planet);
		return repo.save(newPlanet);
	}
	private void updateData(Planet newPlanet, Planet planet) {
		newPlanet.setNome(planet.getNome());
		newPlanet.setClima(planet.getClima());
		newPlanet.setTerreno(planet.getTerreno());
	}

	public Planet fromDTO(PlanetDTO objDto) {
		return new Planet(objDto.getId(),objDto.getNome(),objDto.getClima(),objDto.getTerreno());
	}
	
	
}
