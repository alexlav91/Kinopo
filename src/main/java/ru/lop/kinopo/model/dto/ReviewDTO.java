package ru.lop.kinopo.model.dto;

import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.model.entity.Film;

public class ReviewDTO {

    private double rating;

    private String message;

    private String date;
    private Critic critic;
    private Film film;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Critic getCritic() {
        return critic;
    }

    public void setCritic(Critic critic) {
        this.critic = critic;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
