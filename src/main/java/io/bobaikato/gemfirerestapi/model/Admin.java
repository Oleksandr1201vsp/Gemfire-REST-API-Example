package io.bobaikato.gemfirerestapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

import java.util.concurrent.atomic.AtomicLong;

@Region("customer")
public class Admin {

    private static AtomicLong COUNTER = new AtomicLong(0L);

    @Id
    private Long id;
    private String firstname;
    private String lastname;

    @PersistenceConstructor
    Admin() {
        this.id = COUNTER.incrementAndGet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
