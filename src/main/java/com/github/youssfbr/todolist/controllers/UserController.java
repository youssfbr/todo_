package com.github.youssfbr.todolist.controllers;

import com.github.youssfbr.todolist.entities.User;
import com.github.youssfbr.todolist.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user)  {
        return userService.create(user);
    }

}
