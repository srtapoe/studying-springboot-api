package com.studying_javinha.studies.domain;

import com.studying_javinha.studies.dto.PlanetDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planet")
@EqualsAndHashCode(of = "id")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String weather;
    private String land;

    @Column(name = "views_on_movies")
    private int viewsOnMovies;


    public Planet(PlanetDTO dto) {
        this.name = dto.name();
        this.weather = dto.weather();
        this.land = dto.land();
        this.viewsOnMovies = dto.viewsOnMovies();
    }
}
