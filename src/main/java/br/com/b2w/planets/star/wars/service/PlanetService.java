package br.com.b2w.planets.star.wars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.planets.star.wars.domain.Planet;
import br.com.b2w.planets.star.wars.repository.PlanetRepository;

@Service
public class PlanetService {

	@Autowired
	PlanetRepository repo;
	public List<Planet> findAll(){
		return repo.findAll();
	}
}
