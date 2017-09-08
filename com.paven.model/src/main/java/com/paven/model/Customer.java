package com.paven.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deika on 2017/6/18.
 */
@Entity
@Table(name = "customer")
public class Customer extends Person {

    @OneToMany(mappedBy = "master", targetEntity = Pet.class, fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Customer() {
        this.pets = new ArrayList<Pet>();
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        if(this.pets == null)
            this.pets = new ArrayList<Pet>();
        this.pets.add(pet);
    }
}
