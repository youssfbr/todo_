package com.github.youssfbr.todolist.controllers;

import com.github.youssfbr.todolist.entities.Task;
import com.github.youssfbr.todolist.services.ITaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task, HttpServletRequest request)  {

        Object idUser = request.getAttribute("idUser");
        task.setIdUser((UUID) idUser);

        return taskService.create(task);
    }

}
