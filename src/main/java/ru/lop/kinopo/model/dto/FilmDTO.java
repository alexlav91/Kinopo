package ru.lop.kinopo.model.dto;

import ru.lop.kinopo.model.entity.Genre;

import java.util.List;

public class FilmDTO {

    private String nameOfFilm;

    private String descriptionOfFilm;

    private double durationOfFilm;

    private double ratingOfFilm;

    private int year;

    List<Long> genreList;


    public String getNameOfFilm() {
        return nameOfFilm;
    }

    public void setNameOfFilm(String nameOfFilm) {
        this.nameOfFilm = nameOfFilm;
    }

    public String getDescriptionOfFilm() {
        return descriptionOfFilm;
    }

    public void setDescriptionOfFilm(String descriptionOfFilm) {
        this.descriptionOfFilm = descriptionOfFilm;
    }

    public double getDurationOfFilm() {
        return durationOfFilm;
    }

    public void setDurationOfFilm(double durationOfFilm) {
        this.durationOfFilm = durationOfFilm;
    }

    public double getRatingOfFilm() {
        return ratingOfFilm;
    }

    public void setRatingOfFilm(double ratingOfFilm) {
        this.ratingOfFilm = ratingOfFilm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Long> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Long> genreList) {
        this.genreList = genreList;
    }
}
