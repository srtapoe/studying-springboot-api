package com.studying_javinha.studies.dto;

import com.studying_javinha.studies.domain.Planet;

public record PlanetInformationsDTO(Long id, String name, String weather, String land, int viewsOnMovies) {
    public PlanetInformationsDTO(Planet planet) {
                this(planet.getId(),
                planet.getName(),
                planet.getWeather(),
                planet.getLand(),
                planet.getViewsOnMovies());
    }
}
