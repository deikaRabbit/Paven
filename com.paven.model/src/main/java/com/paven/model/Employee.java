package com.paven.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by deika on 2017/9/5.
 */
@Entity
@Table(name = "employee")
public class Employee extends Person{

    private Short level;

    public Employee() {
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }
}
