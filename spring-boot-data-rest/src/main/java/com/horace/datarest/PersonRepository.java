package com.horace.datarest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * 我们甚至连 controller都没有写，就访问了这么多的rest url。
 *  * 我们只通过@RepositoryRestResource(collectionResourceRel = "person", path = "person")在 dao 中就能够把 /path路径暴露出来。
 *  * 边一切都有了，这就是spring-data-rest的魔力。
 */

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> , JpaSpecificationExecutor<Person> {
    List<Person> findByLastName(@Param("name") String name);  //手写的方法，可以通过search访问，如http://localhost:8000/person/search/findByLastName?name=cat
}
