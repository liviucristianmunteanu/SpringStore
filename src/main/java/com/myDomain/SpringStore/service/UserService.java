package com.myDomain.SpringStore.service;

import com.myDomain.SpringStore.model.MyUser;
import com.myDomain.SpringStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    public Optional<MyUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void saveUser(MyUser user) {
        userRepository.save(user);
    }
    public void addUser(MyUser user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


}
