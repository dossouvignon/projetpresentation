package com.example.cmproMonNewprojet.repository;

import com.example.cmproMonNewprojet.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    public Long countById(Integer id);
}
