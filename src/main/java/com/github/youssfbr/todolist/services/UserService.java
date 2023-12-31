package com.github.youssfbr.todolist.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.youssfbr.todolist.entities.User;
import com.github.youssfbr.todolist.repositories.IUserRepository;
import com.github.youssfbr.todolist.services.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        String passwordHasred = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(passwordHasred);

        return userRepository.save(user);
    }
}
