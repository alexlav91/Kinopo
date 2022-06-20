package ru.lop.kinopo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.GenreNotFoundException;
import ru.lop.kinopo.model.dto.GenreDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Genre;
import ru.lop.kinopo.repository.FilmRepository;
import ru.lop.kinopo.repository.GenreRepository;
import ru.lop.kinopo.service.GenreService;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class GenreServiceImp implements GenreService {
    private final GenreRepository genreRepository;
    private final FilmRepository filmRepository;


    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Genre saveGenre(GenreDto genreDto) {
        Genre genre1=new Genre();
        genre1.setNameOfGenre(genreDto.getNameOfGenre());
        genre1.setDescriptionOfGenre(genreDto.getDescriptionOfGenre());
        return genreRepository.save(genre1);
    }

    @Override
    public Genre getGenreByID(long id) {
        Optional<Genre> optional=genreRepository.findById(id);
        Genre genre=null;
        if(optional.isPresent()){
            genre=optional.get();
        } else {
            throw new RuntimeException("Genre not found for id: "+id);
        }
        return genre;
    }

    @Override
    public void deleteGenreByID(long id) {
    this.genreRepository.findById(id);
    }

    @Override
    public Genre updateGenreById(long id, GenreDto genre) throws GenreNotFoundException {
        Genre genre1=genreRepository.findById(id).orElseThrow(()->new GenreNotFoundException("Жанр с таким ID не найден"));
        genre1.setNameOfGenre(genre.getNameOfGenre());
        genre1.setDescriptionOfGenre(genre.getDescriptionOfGenre());
        return genreRepository.save(genre1);
    }
    @Override
    public Set<Film> getFilmsByGenre(long id) throws GenreNotFoundException {
        Genre genre=genreRepository.findById(id).orElseThrow(()->new GenreNotFoundException("Жанр с таким ID не найден"));
        return genre.getFilmList();
    }
}
