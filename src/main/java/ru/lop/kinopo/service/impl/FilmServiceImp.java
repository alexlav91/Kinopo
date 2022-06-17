package ru.lop.kinopo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.model.dto.FilmDTO;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.repository.FilmRepository;
import ru.lop.kinopo.repository.GenreRepository;
import ru.lop.kinopo.service.FilmService;

import java.util.List;
import java.util.Optional;


@Service
public class FilmServiceImp implements FilmService {
    private FilmRepository filmRepository;
    private GenreRepository genreRepository;

    @Autowired
    public FilmServiceImp(FilmRepository filmRepository, GenreRepository genreRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(long id) {
        Optional<Film> optional=filmRepository.findById(id);
        Film film=null;
        if(optional.isPresent()){
            film=optional.get();
        }else{
            throw new RuntimeException("Film not found for id: "+id);
        }
        return film;
    }

    @Override
    public Film saveFilm(FilmDTO film) {
        Film film1=new Film();
        film1.setNameOfFilm(film.getNameOfFilm());
        film1.setDescriptionOfFilm(film.getDescriptionOfFilm());
        film1.setDurationOfFilm(film.getDurationOfFilm());
        film1.setRatingOfFilm(film.getRatingOfFilm());
        film1.setYear(film.getYear());
        film1.setGenreList(genreRepository.findAllById(film.getGenreList()));
        return filmRepository.save(film1);
    }

    @Override
    public void deleteFilmBeId(long id) {
        this.filmRepository.deleteById(id);
    }

    @Override
    public Film updateFilmById(long id, FilmDTO film) throws FilmNotFoundException {
        Film film1=filmRepository.findById(id).orElseThrow(()-> new FilmNotFoundException("Фильм с таким ID не найден"));
        film1.setNameOfFilm(film.getNameOfFilm());
        film1.setDescriptionOfFilm(film.getDescriptionOfFilm());
        film1.setDurationOfFilm(film.getDurationOfFilm());
        film1.setRatingOfFilm(film.getRatingOfFilm());
        film1.setYear(film.getYear());
        return filmRepository.save(film1);
    }


}
