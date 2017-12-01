package com.paven.db.repository;

import com.paven.model.Person;
import com.paven.model.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by deika on 2017/7/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository customerRespo;

    @Autowired
    private PetRepository petRespo;

    @Test
    public void basicTest(){
        Person c1 = new Person();
        c1.setName("test");
        c1.setSex((short) 1);
        c1.setHome_tel("0912222111");
        c1.setAddress("bbba");

        Pet pet = new Pet();
        pet.setMaster(c1);
        pet.setName("jacky");
        pet.setSex((short)1);
        pet.setBloodType((short)1);


        customerRespo.save(c1);
        assertEquals(1, customerRespo.count());

        petRespo.save(pet);
        assertEquals(1, petRespo.count());

        Pet tempPet = petRespo.findOne(pet.getId());
        assertNotNull(tempPet.getMaster());

        Person fetchC1 = customerRespo.findOne(c1.getId());
        assertNotNull(fetchC1);

        assertEquals(c1.getId(), tempPet.getMaster().getId());

        assertEquals(1, fetchC1.getPets().size());

        fetchC1.setName("abc");
        customerRespo.save(fetchC1);
        assertEquals(1, customerRespo.count());

        Person fetchC2 = customerRespo.findOne(c1.getId());
        assertEquals(fetchC1.getUsername(), fetchC2.getUsername());

        customerRespo.delete(c1.getId());
        assertEquals(0, customerRespo.count());
        assertEquals(0, petRespo.count());
    }
}
