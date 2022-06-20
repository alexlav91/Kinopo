package ru.lop.kinopo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.model.dto.FilmDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Review;
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
    public Film saveFilm(FilmDto film) {
        Film film1=new Film();
        film1.setNameOfFilm(film.getNameOfFilm());
        film1.setDescriptionOfFilm(film.getDescriptionOfFilm());
        film1.setDurationOfFilm(film.getDurationOfFilm());
        film1.setRatingOfFilm(5.0);
        film1.setYear(film.getYear());
        film1.getGenreList().addAll(genreRepository.findAllById(film.getGenreList()));
        return filmRepository.save(film1);
    }

    @Override
    public void deleteFilmBeId(long id) {
        this.filmRepository.deleteById(id);
    }

    @Override
    public Film updateFilmById(long id, FilmDto film) throws FilmNotFoundException {
        Film film1=filmRepository.findById(id).orElseThrow(()-> new FilmNotFoundException("Фильм с таким ID не найден"));
        film1.setNameOfFilm(film.getNameOfFilm());
        film1.setDescriptionOfFilm(film.getDescriptionOfFilm());
        film1.setDurationOfFilm(film.getDurationOfFilm());
//        film1.setRatingOfFilm(film.getRatingOfFilm());
        film1.setYear(film.getYear());
        film1.getGenreList().addAll(genreRepository.findAllById(film.getGenreList()));
        return filmRepository.save(film1);
    }

    @Override
    public List<Review> findReviewsByFilm(long id) throws FilmNotFoundException {
       Film film=filmRepository.findById(id).orElseThrow(()->new FilmNotFoundException("Фильма с таким ID нейден"));
        return film.getReviewList();
    }

}
