package com.example.cmproMonNewprojet.service;

import com.example.cmproMonNewprojet.models.Contact;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface IContactService {
    void add(Contact contact);

    public List<Contact> getList();

    public Contact get(Integer id) throws UserPrincipalNotFoundException;
}
