package com.paven.db.repository;

import com.paven.model.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


/**
 * Created by deika on 2017/6/18.
 */
@Transactional
public interface CustomerRespository extends CrudRepository<Customer, Long> {
}
