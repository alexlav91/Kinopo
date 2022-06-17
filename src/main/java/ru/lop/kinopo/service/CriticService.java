package ru.lop.kinopo.service;


import ru.lop.kinopo.exceptions.CriticNotFoundExceptions;
import ru.lop.kinopo.model.dto.CriticDTO;
import ru.lop.kinopo.model.entity.Critic;

import java.util.List;

public interface CriticService {
    List<Critic> getAllCritics();
    Critic saveCritic(CriticDTO criticDTO);
    Critic getCriticById(long id);
    void deleteCriticById(long id);
    Critic updateCriticById(long id, CriticDTO critic) throws CriticNotFoundExceptions;

}
