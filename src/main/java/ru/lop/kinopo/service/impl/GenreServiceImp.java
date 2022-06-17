package ru.lop.kinopo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.GenreNotFoundException;
import ru.lop.kinopo.model.dto.GenreDTO;
import ru.lop.kinopo.model.entity.Genre;
import ru.lop.kinopo.repository.GenreRepository;
import ru.lop.kinopo.service.GenreService;

import java.util.List;
import java.util.Optional;


@Service
public class GenreServiceImp implements GenreService {
    private GenreRepository genreRepository;
    @Autowired
    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Genre saveGenre(GenreDTO genre) {
        Genre genre1=new Genre();
        genre1.setNameOfGenre(genre.getNameOfGenre());
        genre1.setDescriptionOfGenre(genre.getNameOfGenre());
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
    public Genre updateGenreById(long id, GenreDTO genre) throws GenreNotFoundException {
        Genre genre1=genreRepository.findById(id).orElseThrow(()->new GenreNotFoundException("Жанр с таким ID не найден"));
        genre1.setNameOfGenre(genre.getNameOfGenre());
        genre1.setDescriptionOfGenre(genre.getNameOfGenre());
        return genreRepository.save(genre1);
    }
}
