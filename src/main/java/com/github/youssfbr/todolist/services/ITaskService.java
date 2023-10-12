package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.Task;
import jakarta.servlet.http.HttpServletRequest;

public interface ITaskService {

    Task create(final Task task, HttpServletRequest request);

}
