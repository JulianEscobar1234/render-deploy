package com.example.demo.service.interfaces;

import com.example.demo.entity.PersonEntity;

import java.util.List;

public interface IPersonService {
    public List<PersonEntity> getAllPersons();

    public void createPerson(PersonEntity person);

    public void deletePerson(Long id);

    public PersonEntity updatePerson(PersonEntity person);
}

