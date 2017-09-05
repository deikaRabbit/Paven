package com.paven.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by deika on 2017/9/5.
 */
@Entity
@Table(name="pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short sex;

    private Short category;

    private Short type;

    @Column(length=32)
    private String name;

    private Short bloodType;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "master_id")
    private Customer master;

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getBloodType() {
        return bloodType;
    }

    public void setBloodType(Short bloodType) {
        this.bloodType = bloodType;
    }

    public Customer getMaster() {
        return master;
    }

    public void setMaster(Customer master) {
        this.master = master;
    }
}
