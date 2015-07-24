package com.json.common.models;

import java.util.List;

/**
 * Created by churmuzache on 7/24/15.
 */
public class Company {
    private String name;
    private String address;
    private List<Person> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
