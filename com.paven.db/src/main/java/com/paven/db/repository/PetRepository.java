package com.paven.db.repository;

import com.paven.model.Pet;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by deika on 2017/9/5.
 */
@Transactional
public interface PetRepository extends CrudRepository<Pet, Long> {
}
