package com.github.youssfbr.todolist.services;

import com.github.youssfbr.todolist.entities.User;
import com.github.youssfbr.todolist.repositories.IUserRepository;
import com.github.youssfbr.todolist.services.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        User userExist = userRepository.findByUsername(user.getUsername());
        if (userExist != null) {
            //System.out.println("Usuário já existe!");
            //return null;
            throw new UsernameExistsException("Usuário já existe!");
        }
        return userRepository.save(user);
    }
}
