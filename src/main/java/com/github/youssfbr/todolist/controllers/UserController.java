package com.github.youssfbr.todolist.controllers;

import com.github.youssfbr.todolist.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public void create(@RequestBody User user) {
        System.out.println(user);
    }

}
