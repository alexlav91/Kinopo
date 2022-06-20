package ru.lop.kinopo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lop.kinopo.exceptions.GenreNotFoundException;
import ru.lop.kinopo.model.dto.GenreDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Genre;
import ru.lop.kinopo.service.impl.GenreServiceImp;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Genre")
public class GenreController {
    private GenreServiceImp genreServiceImp;
    @Autowired
    public GenreController(GenreServiceImp genreServiceImp) {

        this.genreServiceImp = genreServiceImp;
    }
    @GetMapping("/")
    @ApiOperation("Получить список жанров")
    public List<Genre> viewGenreHomePage(Model model){
        model.addAttribute(genreServiceImp.getAllGenre());
        return genreServiceImp.getAllGenre();
    }
    @GetMapping("{id}")
    @ApiOperation("Получить жанр")
    public Genre getOneGenre(@PathVariable("id")long id, Model model){
        model.addAttribute(genreServiceImp.getGenreByID(id));
        return genreServiceImp.getGenreByID(id);
    }
    @PostMapping("/")
    @ApiOperation("Добавить жанр")
    public  Genre createGenre(@RequestBody GenreDto genre){
        return genreServiceImp.saveGenre(genre);
    }
    @PutMapping("{id}")
    @ApiOperation("Обновить данные о жанре")
    public Genre updateGenre(@RequestBody GenreDto genre, @PathVariable(value = "id")long id) throws GenreNotFoundException {
        return genreServiceImp.updateGenreById(id,genre);
    }
    @DeleteMapping("{id}")
    @ApiOperation("Удалить жанр")
    public void deleteGenre(@PathVariable(value = "id")long id){
        this.genreServiceImp.deleteGenreByID(id);
    }

    @GetMapping("showFilmsByGenre/{id}")
    @ApiOperation("Список фильмов по жанру")
    public Set<Film> viewFilmByGenre(@PathVariable(name = "id")long id, Model model) throws GenreNotFoundException {
        model.addAttribute(genreServiceImp.getFilmsByGenre(id));
        return genreServiceImp.getFilmsByGenre(id);
    }
}


