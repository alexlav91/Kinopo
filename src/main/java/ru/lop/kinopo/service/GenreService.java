package ru.lop.kinopo.service;

import ru.lop.kinopo.exceptions.GenreNotFoundException;
import ru.lop.kinopo.model.dto.GenreDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Genre;

import java.util.List;
import java.util.Set;

public interface GenreService {
    List<Genre> getAllGenre();
    Genre saveGenre(GenreDto genreDTO);
    Genre getGenreByID(long id);
     void deleteGenreByID(long id);
     Genre updateGenreById(long id, GenreDto genre) throws GenreNotFoundException;
     Set<Film> getFilmsByGenre(long id) throws GenreNotFoundException;

}
