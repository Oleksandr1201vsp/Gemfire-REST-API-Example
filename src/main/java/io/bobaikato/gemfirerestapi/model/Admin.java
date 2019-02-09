package io.bobaikato.gemfirerestapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@Region("customer")
public class Admin implements Serializable {

    private static final long serialVersionUID = 2053563339980357876L;
    private static AtomicLong COUNTER = new AtomicLong(0L);

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @PersistenceConstructor
    Admin() {
        this.id = COUNTER.incrementAndGet();
    }

    public Admin(String firstName, String lastName) {
        this.id = COUNTER.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
