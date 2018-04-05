package com.naya.personbd;

import com.naya.personbd.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface PersonDao extends JpaRepository<Person,Long> {
    @RestResource(path = "byAge")
    List<Person> findByAgeGreaterThan(@Param("min") int min);

}
