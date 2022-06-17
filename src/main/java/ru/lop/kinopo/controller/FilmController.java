package ru.lop.kinopo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.model.dto.CriticDTO;
import ru.lop.kinopo.model.dto.FilmDTO;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.service.impl.CriticServiceImp;
import ru.lop.kinopo.service.impl.FilmServiceImp;

import java.util.List;


@RestController
@RequestMapping("/film")
public class FilmController {
    private FilmServiceImp filmServiceImp;
    @Autowired
    public FilmController(FilmServiceImp filmServiceImp) {

        this.filmServiceImp = filmServiceImp;
    }
    @GetMapping("/")
    @ApiOperation("Получить список фильмов")
    public List<Film> viewFilmHomePage(Model model) {
        model.addAttribute(filmServiceImp.getAllFilms());
        return filmServiceImp.getAllFilms();
    }
    @GetMapping("{id}")
    @ApiOperation("Получить фильм")
    public Film getOneFilm(@PathVariable("id")long id, Model model){
        model.addAttribute(filmServiceImp.getFilmById(id));
        return filmServiceImp.getFilmById(id);
    }
    @PostMapping("/")
    @ApiOperation("Добавить фильм")
    public Film createFilm(@RequestBody FilmDTO film){

        return  filmServiceImp.saveFilm(film);
    }
    @PutMapping("{id}")
    @ApiOperation("Обновить данные о фильме")
    public Film updateFilm(@RequestBody FilmDTO film, @PathVariable(value="id")long id) throws FilmNotFoundException {
        return  filmServiceImp.updateFilmById(id,film);
    }
    @DeleteMapping("{id}")
    @ApiOperation("Удалить фильм")
    public void deleteFilm(@PathVariable(value="id")long id){
        this.filmServiceImp.deleteFilmBeId(id);
    }

}
