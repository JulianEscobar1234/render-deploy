package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImplements implements IPersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    @Transactional
    public List<PersonEntity> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    @Transactional
    public void createPerson(PersonEntity person) {
        personRepo.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    @Transactional
    public PersonEntity updatePerson(PersonEntity person) {
        return personRepo.save(person);
    }
}
