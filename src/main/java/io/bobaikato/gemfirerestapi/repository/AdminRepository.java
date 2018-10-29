package io.bobaikato.gemfirerestapi.repository;

import io.bobaikato.gemfirerestapi.model.Admin;

import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Trace
    Collection<Admin> findAll();

    @Trace
    Admin findById(@Param("id") Long id);
}
