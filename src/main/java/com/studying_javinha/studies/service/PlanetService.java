package com.studying_javinha.studies.service;


import com.studying_javinha.studies.domain.Planet;
import com.studying_javinha.studies.dto.PlanetDTO;
import com.studying_javinha.studies.exceptions.PlanetNotFoundException;
import com.studying_javinha.studies.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> getAllPlanets() {
        return this.planetRepository.findAll();
    }

    public Planet getPlanetById(long id) throws PlanetNotFoundException {
        return planetRepository.findById(id).orElseThrow(() -> new PlanetNotFoundException("Planet not found"));
    }

    public Planet createPlanet(PlanetDTO planetDto) {
        Planet newPlanet = new Planet(planetDto);
        return planetRepository.save(newPlanet);
    }

    public Planet getByName(String name) throws PlanetNotFoundException {
        return planetRepository.findByName(name).orElseThrow(() -> new PlanetNotFoundException("Planet not found"));
    }

    public void removeById(long id) {
        this.planetRepository.deleteById(id);
    }
}
