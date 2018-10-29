package io.bobaikato.gemfirerestapi.model;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

@Region("customer")
public class Customer {

    private static AtomicLong COUNTER = new AtomicLong(0L);

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @PersistenceConstructor
    Customer() {
        this.id = COUNTER.incrementAndGet();
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

    public String toString() {
        return "firstName: " + firstName + " ,lastName: " + lastName + " ,age: " + age;
    }

}