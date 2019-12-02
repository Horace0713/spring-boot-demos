package com.horace.datarest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);  //手写的方法，可以通过search访问，如http://localhost:8000/person/search/findByLastName?name=cat
}
