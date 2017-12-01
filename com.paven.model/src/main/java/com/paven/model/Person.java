package com.paven.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by deika on 2017/9/5.
 */
@Entity
@Table(name = "person")
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=32)
    private String name;

    @Column(length=64)
    private String password;

    @Column(length=16)
    private String home_tel;

    @Column(length=16)
    private String mobile_tel;

    private Short sex;

    @Column(length=200)
    private String address;

    private Short privilege;

    @OneToMany(mappedBy = "master", targetEntity = Pet.class, fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Person() {
        this.privilege = 0;
    }

    public Person(String name, String password){
        this();
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Short getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Short privilege) {
        this.privilege = privilege;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(getPrivilege().toString()));
        return auths;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
