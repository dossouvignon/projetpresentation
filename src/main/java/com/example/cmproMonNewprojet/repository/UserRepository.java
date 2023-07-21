package com.example.cmproMonNewprojet.repository;

import com.example.cmproMonNewprojet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    public Long countById(Integer id);
}
