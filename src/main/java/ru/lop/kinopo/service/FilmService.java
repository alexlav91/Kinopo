package ru.lop.kinopo.service;

import ch.qos.logback.core.net.server.Client;
import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.model.dto.FilmDTO;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.model.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();
    Film getFilmById(long id);
    Film saveFilm(FilmDTO film);
    void deleteFilmBeId(long id);
    Film updateFilmById(long id, FilmDTO filmD) throws FilmNotFoundException;
}
