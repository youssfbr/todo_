package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.Task;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ITaskService {

    Task create(final Task task, HttpServletRequest request);
    List<Task> list(HttpServletRequest request);

}
