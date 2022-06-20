package ru.lop.kinopo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "Genre")
@Setter
@Getter
public class Genre {
    @Id
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "increment",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "MY_SEQUENCE")
    )
    @GeneratedValue(generator = "ID_GENERATOR")
    private long id;
    @Column(name="name_of_genre")
    private String nameOfGenre;
    @Column(name="description_of_gener")
    private String descriptionOfGenre;


    @ManyToMany(mappedBy = "genreList")
    private Set<Film> filmList=new HashSet<>();
}
