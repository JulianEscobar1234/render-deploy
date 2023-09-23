package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "person")
@Data

public class PersonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id_person;

    @NotNull
    @Size(min=10,max = 50)
    @Column(name = "name")
    private String name;


    @NotNull
    @Size(min=10,max = 50)
    @Column(name = "lastname")
    private String lastname;


    @NotNull
    @Size(min=10,max = 50)
    @Column(name = "email")
    private String email;

}
