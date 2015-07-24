package com.json.common.models;

import java.util.Date;

/**
 * Created by churmuzache on 7/24/15.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String emailAddress;
    private double salary;
    private Date birthDate;


    public Person(String firstName, String lastName, int age, String emailAddress, double salary, Date birthDate){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.emailAddress=emailAddress;
        this.salary=salary;
        this.birthDate=birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
