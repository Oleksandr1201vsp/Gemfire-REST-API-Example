package io.bobaikato.gemfirerestapi.controller;

import io.bobaikato.gemfirerestapi.model.Admin;
import io.bobaikato.gemfirerestapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ApplicationController {

    private final AdminRepository adminRepository;

    @Autowired
    public ApplicationController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("admins")
    public Collection<?> getAllAdmins() {
        adminRepository.save(new Admin(1L, "Bobai", "Kato"));
        return adminRepository.findAll();
    }
}
