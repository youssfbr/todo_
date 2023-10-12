package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.Task;
import com.github.youssfbr.todolist.repositories.ITaskRepository;
import com.github.youssfbr.todolist.services.exceptions.DateException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
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

        LocalDateTime currentDate = LocalDateTime.now();
        if (currentDate.isAfter(task.getStartAt()) || currentDate.isAfter(task.getEndAt())) {
            throw new DateException("A data deve digitada ser maior que a data e hora atual.");
        }

        if (task.getStartAt().isAfter(task.getEndAt())) {
            throw new DateException("A data de inicio deve ser menor que a data de termino.");
        }

        return taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> list(HttpServletRequest request) {

        Object idUserResult = request.getAttribute("idUser");

        return taskRepository.findByIdUser((UUID) idUserResult);

    }
}
