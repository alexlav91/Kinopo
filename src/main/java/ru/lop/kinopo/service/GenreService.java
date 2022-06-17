package ru.lop.kinopo.service;

import ru.lop.kinopo.exceptions.GenreNotFoundException;
import ru.lop.kinopo.model.dto.GenreDTO;
import ru.lop.kinopo.model.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenre();
    Genre saveGenre(GenreDTO genreDTO);
    Genre getGenreByID(long id);
     void deleteGenreByID(long id);
     Genre updateGenreById(long id, GenreDTO genre) throws GenreNotFoundException;

}
