package br.com.b2w.planets.star.wars.dto;

import java.io.Serializable;

import br.com.b2w.planets.star.wars.domain.Planet;

public class PlanetDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	public PlanetDTO() {
		
	}
	public PlanetDTO(Planet planet) {
		id= planet.getId();
		nome = planet.getNome();
		clima = planet.getClima();
		terreno = planet.getTerreno();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
}
