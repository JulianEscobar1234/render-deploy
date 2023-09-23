package com.example.demo.repo;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity, Long>{
    //Custom Query
}
