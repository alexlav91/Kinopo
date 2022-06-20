package ru.lop.kinopo.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.model.entity.Film;
@Setter
@Getter
public class ReviewDto {

    private double rating;

    private String message;

    private String date;
    private Critic critic;
    private Film film;

}
