package com.github.youssfbr.todolist.controllers;

import com.github.youssfbr.todolist.entities.Task;
import com.github.youssfbr.todolist.services.ITaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task, HttpServletRequest request)  {
        return taskService.create(task, request);
    }

}
