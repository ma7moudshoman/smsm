package com.example.os.service;

import com.example.os.model.User;
import com.example.os.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    User saveUser(User user){
        return    userRepository.save(user);
    }

    public User  save2(String name, int age, String phone) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setPhone(phone);
        userRepository.save(user);
        return    userRepository.save(user);
    }
}
