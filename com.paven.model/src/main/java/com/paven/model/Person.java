package com.paven.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by deika on 2017/9/5.
 */
@MappedSuperclass
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=32)
    private String name;

    @Column(length=16)
    private String home_tel;

    @Column(length=16)
    private String mobile_tel;

    private Short sex;

    @Column(length=200)
    private String address;

    @Deprecated
    public Person(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_tel() {
        return home_tel;
    }

    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }

    public String getMobile_tel() {
        return mobile_tel;
    }

    public void setMobile_tel(String mobile_tel) {
        this.mobile_tel = mobile_tel;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
