package ru.lop.kinopo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class GenreDto {

    private String nameOfGenre;

    private String descriptionOfGenre;
    private List<Long> filmList;
}




