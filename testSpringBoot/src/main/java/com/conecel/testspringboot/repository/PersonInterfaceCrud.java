package com.conecel.testspringboot.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conecel.testspringboot.entity.Person;


@Repository
public interface PersonInterfaceCrud extends CrudRepository<Person, String> {

   Person findByIdentificationId(String identificationId);

}
