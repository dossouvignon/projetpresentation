package com.example.cmproMonNewprojet.service;

import com.example.cmproMonNewprojet.models.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface IUserService {
    void add(User user);
    public List<User> getList();
    public User get(Integer id) throws UserPrincipalNotFoundException;
}
