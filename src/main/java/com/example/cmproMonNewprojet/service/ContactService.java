package com.example.cmproMonNewprojet.service;

import com.example.cmproMonNewprojet.models.Contact;
import com.example.cmproMonNewprojet.models.User;
import com.example.cmproMonNewprojet.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void add(Contact contact) {
        contactRepository.save(contact);

    }

    @Override
    public List<Contact> getList() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact get(Integer id) throws UserPrincipalNotFoundException {
        Optional<Contact> resultContact =  contactRepository.findById(id);
        if(resultContact.isPresent()){
            return resultContact.get();
        }

        throw new UserPrincipalNotFoundException("Could not finf this contact with this " + id);
    }


    public void delete(Integer id) throws UserNotFoundException, UserPrincipalNotFoundException {
        Long count = contactRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserPrincipalNotFoundException("Could not find any contact with ID " + id);
        }
        contactRepository.deleteById(id);
    }
}
