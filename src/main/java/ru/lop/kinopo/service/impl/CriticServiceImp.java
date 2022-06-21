package ru.lop.kinopo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.CriticNotFoundExceptions;
import ru.lop.kinopo.model.dto.CriticDto;
import ru.lop.kinopo.model.entity.Critic;
import ru.lop.kinopo.repository.CriticRepository;
import ru.lop.kinopo.service.CriticService;

import java.util.List;
import java.util.Optional;


@Service
public class CriticServiceImp implements CriticService {
    private CriticRepository criticRepository;
    @Autowired
    public CriticServiceImp(CriticRepository criticRepository) {
        this.criticRepository = criticRepository;
    }
    @Override
    public List<Critic> getAllCritics() {
        return criticRepository.findAll();
    }
    @Override
    public Critic getCriticById(long id) {
        Optional<Critic>optional=criticRepository.findById(id);
        Critic critic=null;
        if(optional.isPresent()){
            critic=optional.get();
        }else {
            throw new RuntimeException("Critic not found for id: "+id);
            }
        return critic;
    }

    @Override
    public void deleteCriticById(long id) {
        this.criticRepository.deleteById(id);
    }
    @Override
    public Critic updateCriticById(long id, CriticDto critic) throws CriticNotFoundExceptions {
        Critic critic1=criticRepository.findById(id).orElseThrow(() -> new CriticNotFoundExceptions("Критик с таким ID не найден"));
        critic1.setNameOfCritic(critic.getNameOfCritic());
        critic1.setSurnameOfCritic(critic.getSurnameOfCritic());
        critic1.setPersonalInformation(critic.getPersonalInformation());

        return this.criticRepository.save(critic1);
    }
    @Override
    public Critic saveCritic(CriticDto critic) {
        Critic critic1=new Critic();
        critic1.setNameOfCritic(critic.getNameOfCritic());
        critic1.setSurnameOfCritic(critic.getSurnameOfCritic());
        critic1.setPersonalInformation(critic.getPersonalInformation());
        return this.criticRepository.save(critic1);
    }
}
