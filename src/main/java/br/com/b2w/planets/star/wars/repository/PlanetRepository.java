package br.com.b2w.planets.star.wars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.b2w.planets.star.wars.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

}
