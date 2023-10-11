package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.Task;
import com.github.youssfbr.todolist.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    @Override
    @Transactional
    public Task create(Task task) {
        return taskRepository.save(task);
    }
}
