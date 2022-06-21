package ru.lop.kinopo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Review")
@Setter
@Getter
public class Review {
    @Id
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "increment",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "MY_SEQUENCE")
    )
    @GeneratedValue(generator = "ID_GENERATOR")
    private long id;
    @Column(name="rating")
    private double rating;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private String date;
    @ManyToOne
    @JoinColumn(name="critic_id")
    @JsonIgnore
    private Critic critic;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}