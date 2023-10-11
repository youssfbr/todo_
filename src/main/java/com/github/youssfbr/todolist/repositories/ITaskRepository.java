package com.github.youssfbr.todolist.repositories;

import com.github.youssfbr.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository extends JpaRepository<Task, UUID> {

}
