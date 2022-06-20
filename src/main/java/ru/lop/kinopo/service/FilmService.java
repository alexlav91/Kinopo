package ru.lop.kinopo.service;

import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.model.dto.FilmDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Review;

import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();
    Film getFilmById(long id);
    Film saveFilm(FilmDto film);
    void deleteFilmBeId(long id);
    Film updateFilmById(long id, FilmDto filmD) throws FilmNotFoundException;
    List<Review> findReviewsByFilm(long id) throws FilmNotFoundException;

}
