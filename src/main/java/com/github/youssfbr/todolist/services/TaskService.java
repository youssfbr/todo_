package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.Task;
import com.github.youssfbr.todolist.repositories.ITaskRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    @Override
    @Transactional
    public Task create(Task task, HttpServletRequest request) {

        Object idUser = request.getAttribute("idUser");
        task.setIdUser((UUID) idUser);

        return taskRepository.save(task);
    }
}
