package ru.lop.kinopo.controller;

import ch.qos.logback.core.net.server.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lop.kinopo.exceptions.CriticNotFoundExceptions;
import ru.lop.kinopo.model.dto.APIResponse;
import ru.lop.kinopo.model.dto.CriticDTO;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.service.impl.CriticServiceImp;


import java.util.List;


@RestController
@RequestMapping("/critic")
public class CriticController {
    private CriticServiceImp criticServiceImp;
    @Autowired
    public CriticController(CriticServiceImp criticServiceImp) {
        this.criticServiceImp = criticServiceImp;
    }
    @GetMapping("/")
    @ApiOperation("Получить список критиков")
    public List<Critic> viewCriticHomePage(Model model){
        model.addAttribute( criticServiceImp.getAllCritics());
        return criticServiceImp.getAllCritics();
    }
    @GetMapping("{id}")
    @ApiOperation("Получить критика")
    public Critic getOneCritic(@PathVariable("id")long id, Model model){
        model.addAttribute(criticServiceImp.getCriticById(id));
        return criticServiceImp.getCriticById(id);
    }
    @PostMapping("/")
    @ApiOperation("Добавить критика")
    public Critic createCritic(@RequestBody CriticDTO critic){

        return  criticServiceImp.saveCritic(critic);
    }

    @PutMapping("{id}")
    @ApiOperation("Обновить данные критика")
    public Critic updateCritic(@RequestBody CriticDTO critic, @PathVariable(value="id") long id ) throws CriticNotFoundExceptions {
       return criticServiceImp.updateCriticById (id, critic);
    }
    @DeleteMapping("{id}")
    @ApiOperation("Удалить критика")
    public void deleteCritic(@PathVariable(value = "id")long id){

        this.criticServiceImp.deleteCriticById(id);
    }


}