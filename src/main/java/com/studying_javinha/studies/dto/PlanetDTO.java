package com.studying_javinha.studies.dto;

import jakarta.validation.constraints.NotBlank;

public record PlanetDTO (@NotBlank String name, String weather, String land, int viewsOnMovies){
}
