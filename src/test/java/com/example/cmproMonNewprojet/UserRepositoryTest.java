package com.example.cmproMonNewprojet;

import com.example.cmproMonNewprojet.models.User;
import com.example.cmproMonNewprojet.repository.UserRepository;
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
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /*public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Test
    public void testAddNew(){
        //Given
        User user = new User();
        user.setEmail("sui.@gmail.com");
        user.setPassword("lotosckdeo");
        user.setFirstName("Yosaa");
        user.setLastName("Yedrhfom");

        //When
        User userSave = userRepository.save(user);

        //Assert
        assertThat(userSave).isNotNull();
        assertThat(userSave.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<User> users= userRepository.findAll();
        assertThat(users).hasSameClassAs(users);
        for(User user:users){
            System.out.println(user);
        }

    }

    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        user.setPassword("tatitati");
        userRepository.save(user);

        User updateUser=userRepository.findById(userId).get();
        assertThat(updateUser.getPassword()).isEqualTo("tatitati");

    }

    @Test
    public void testGet(){
        Integer userId = 2;
        Optional<User> optionalUser = userRepository.findById(userId);
        assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
    @Test
    public void testDelete(){
        Integer userId = 2;
        userRepository.deleteById(userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        assertThat(optionalUser).isNotPresent();

    }
}
