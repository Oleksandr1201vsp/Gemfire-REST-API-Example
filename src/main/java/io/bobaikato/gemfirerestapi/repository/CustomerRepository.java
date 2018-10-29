package io.bobaikato.gemfirerestapi.repository;

import io.bobaikato.gemfirerestapi.model.Customer;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Trace
    Customer findByFirstName(@Param("firstName") String firstName);

    @Trace
    Customer findByLastName(@Param("lastName") String lastName);

    @Trace
    Iterable<Customer> findByAgeGreaterThan(@Param("age") int age);

    @Trace
    Iterable<Customer> findByAgeLessThan(@Param("age") int age);
}