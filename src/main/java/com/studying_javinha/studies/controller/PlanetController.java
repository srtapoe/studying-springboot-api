package com.studying_javinha.studies.controller;

import com.studying_javinha.studies.domain.Planet;
import com.studying_javinha.studies.dto.PlanetDTO;
import com.studying_javinha.studies.dto.PlanetInformationsDTO;
import com.studying_javinha.studies.exceptions.PlanetNotFoundException;
import com.studying_javinha.studies.repository.PlanetRepository;
import com.studying_javinha.studies.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    final PlanetRepository planetRepository;

    final PlanetService planetService;

    public PlanetController(PlanetRepository planetRepository, PlanetService planetService) {
        this.planetRepository = planetRepository;
        this.planetService = planetService;
    }

    @GetMapping
    public List<Planet> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    @PostMapping
    public ResponseEntity<Planet> addPlanet(@RequestBody PlanetDTO planetDTO) {
        Planet createdPlanet = planetService.createPlanet(planetDTO);
        return new ResponseEntity<>(createdPlanet, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPlanetById(@PathVariable long id) throws PlanetNotFoundException {
      Planet planet = planetService.getPlanetById(id);
        return ResponseEntity.ok(new PlanetInformationsDTO(planet));
    }

    @GetMapping("/{name}")
    public ResponseEntity getPlanetByName(@PathVariable String name) throws PlanetNotFoundException {
        Planet planet = planetService.getByName(name);
        return ResponseEntity.ok(new PlanetInformationsDTO(planet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Planet> deletePlanet(@PathVariable long id) {
        this.planetService.removeById(id);
        return ResponseEntity.ok().build();
    }
}
