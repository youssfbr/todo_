package com.github.youssfbr.todolist.repositories;

import com.github.youssfbr.todolist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

}
