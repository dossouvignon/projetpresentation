package com.example.cmproMonNewprojet.service;

import com.example.cmproMonNewprojet.models.User;
import com.example.cmproMonNewprojet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User get(Integer id) throws UserPrincipalNotFoundException {
      Optional<User> result =  userRepository.findById(id);
      if(result.isPresent()){
          return result.get();
      }

         throw new UserPrincipalNotFoundException("Could not finf this user with this " + id);
    }

    public void delete(Integer id) throws UserNotFoundException, UserPrincipalNotFoundException {
        Long count = userRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserPrincipalNotFoundException("Could not find any user with ID " + id);
        }
        userRepository.deleteById(id);
    }

}
