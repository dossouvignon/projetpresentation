package com.example.cmproMonNewprojet;

import com.example.cmproMonNewprojet.models.Contact;
import com.example.cmproMonNewprojet.models.User;
import com.example.cmproMonNewprojet.repository.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testAddNewContact() {

        //Given
        var contact = Contact.
                builder()
                .nom("Bossi")
                .prenom("Théo")
                .email("bg.@gmail.com")
                .numeroTelephone("44-28-23-84")
                .adresseHabitation("AgboVille")
                .nomEntreprise("Elom et fils")
                .preoccupation("Gestion de page Twitter")
                .build();

        //When
        Contact contactSave = contactRepository.save(contact);

        //Assert
        assertThat(contactSave).isNotNull();

    }

    @Test
    public void testListAll() {
        Iterable<Contact> contacts = contactRepository.findAll();

        assertThat(contacts).hasSameClassAs(contacts);
        for (Contact contact : contacts) {
            System.out.println(contacts);
        }

    }


    @Test
    public void testUpdate() {
        Integer contactId = 1;
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        Contact contact = optionalContact.get();
        contact.setNom("Sokpe");
        contactRepository.save(contact);
        //When
        Contact updateContact = contactRepository.findById(contactId).get();
        //Assert
        assertThat(updateContact.getNom()).isEqualTo("Sokpe");

    }

    @Test
    public void testGet(){
        Integer contactId = 2;
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        assertThat(optionalContact).isPresent();
        System.out.println(optionalContact.get());
    }


    @Test
    public void testDelete(){
        Integer contactId = 2;
        contactRepository.deleteById(contactId);
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        assertThat(optionalContact).isNotPresent();

    }
}
