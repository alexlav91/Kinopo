package ru.lop.kinopo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="film")
@Setter
@Getter
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
    @OneToMany(mappedBy = "film")
    private List<Review> reviewList;
    @Column(name="genre")
    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="film_genre",
            joinColumns = {@JoinColumn(name ="genre_id") },
            inverseJoinColumns = {@JoinColumn(name="film_id")}
    )
    @JsonIgnore
    private Set<Genre> genreList =new HashSet<>();
}