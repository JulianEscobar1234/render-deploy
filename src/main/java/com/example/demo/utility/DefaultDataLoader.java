package com.example.demo.utility;


import com.example.demo.entity.PersonEntity;
import com.example.demo.repo.PersonRepo;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataLoader {

    @Autowired
    private PersonRepo personRepo;

    @PostConstruct
    public void init() {
        if (personRepo.count() == 0) {

            PersonEntity person1 = new PersonEntity();
            person1.setName("Person Test 1");
            person1.setLastname("Lastname Test 1");
            person1.setEmail("Email Test 1");
            personRepo.save(person1);


            PersonEntity person2 = new PersonEntity();
            person2.setName("Person Test 2");
            person2.setLastname("Lastname Test 2");
            person2.setEmail("Email Test 2");
            personRepo.save(person2);


            PersonEntity person3 = new PersonEntity();
            person3.setName("Person Test 3");
            person3.setLastname("Lastname Test 3");
            person3.setEmail("Email Test 3");
            personRepo.save(person3);
        }
    }

}
