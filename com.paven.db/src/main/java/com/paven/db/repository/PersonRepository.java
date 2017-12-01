package com.paven.db.repository;

import com.paven.model.Person;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


/**
 * Created by deika on 2017/6/18.
 */
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    public Person findByName(String name);
}
