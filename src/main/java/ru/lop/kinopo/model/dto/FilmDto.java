package ru.lop.kinopo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class FilmDto {

    private String nameOfFilm;

    private String descriptionOfFilm;

    private double durationOfFilm;

//    private double ratingOfFilm;

    private int year;

    private List<Long> genreList;
}
