package ru.lop.kinopo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Genre")
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
    @ManyToMany
    private List <Film> filmList;

    public String getNameOfGenre() {
        return nameOfGenre;
    }

    public void setNameOfGenre(String nameOfGenre) {
        this.nameOfGenre = nameOfGenre;
    }

    public String getDescriptionOfGenre() {
        return descriptionOfGenre;
    }

    public void setDescriptionOfGenre(String descriptionOfGenre) {
        this.descriptionOfGenre = descriptionOfGenre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
