package com.example.os.controller;

import com.example.os.model.User;
import com.example.os.repo.UserRepository;
import com.example.os.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;


    @Autowired
    UserService userService;
    @GetMapping("add")
    public User save(@RequestParam("name") String name,
                       @RequestParam("age") int age,
                       @RequestParam("phone") String phone) {
        System.out.println(name + "  " + age + "  " + phone);
// HIIIIIIIIIIIIIII
        return  userService.save2(name , age , phone);

    }

    @GetMapping("add2")
    public String save2(@RequestBody User u) {
        System.out.println(u.toString());

        userRepository.save(u);
        return "ok";
    }

    @GetMapping("getUser")
    public User get(@RequestParam("id") int id) {

        return userRepository.findById(id).get();

    }

    @GetMapping("deleteUser")
    public String delete(@RequestParam("id") int id) {

         userRepository.deleteById(id);
        return "ok";

    }
    @GetMapping("updateUser")
    public User update(@RequestParam("id") int id , @RequestParam("name") String newname) {

        User user = userRepository.findById(id).get();
        user.setName(newname);
        return userRepository.save(user);

    }
   @GetMapping("getall")
    public List<User> getall() {
       return userRepository.findAll();
   }

}
