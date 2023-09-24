package com.example.demo.rest;

import com.example.demo.entity.PersonEntity;
import com.example.demo.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/person")
public class PersonRest {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping("/getAll")
    private ResponseEntity<List<PersonEntity>> getAll() {
        return ResponseEntity.ok(iPersonService.getAllPersons());
    }

    @PostMapping("/create")
    private ResponseEntity<PersonEntity> create(@Validated @RequestBody PersonEntity person) {
        try {
            iPersonService.createPerson(person);
            ResponseEntity.status(201);
            return ResponseEntity.ok((person));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> delete(@PathVariable("id") Long id) {
        iPersonService.deletePerson(id);
        return ResponseEntity.ok(("person was successfully removed."));
    }

    @PutMapping("/update")
    private ResponseEntity<PersonEntity> update(@RequestBody PersonEntity person) {
        PersonEntity temporal = iPersonService.updatePerson(person);
        try {
            return ResponseEntity.created(new URI("/api/person" + temporal.getId_person())).body(temporal);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
