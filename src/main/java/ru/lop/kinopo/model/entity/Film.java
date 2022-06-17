package ru.lop.kinopo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="film")
public class Film {
    @Id
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "increment",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "MY_SEQUENCE")
    )
    @GeneratedValue(generator = "ID_GENERATOR")
    private long id;
    @Column(name="name_of_film")
    private String nameOfFilm;
    @Column(name = "description_of_film")
    private String descriptionOfFilm;
    @Column(name="duration_of_film")
    private double durationOfFilm;
    @Column(name="rating_of_film")
    private double ratingOfFilm;
    @Column(name="year")
    private int year;
    @Column(name =" review")
    @OneToMany
    private List<Review> reviewList;
    @Column(name="genre")
    @ManyToMany
    private  List<Genre> genreList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}