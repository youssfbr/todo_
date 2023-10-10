package com.github.youssfbr.todolist.services.exceptions;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String mensagem) {
        super(mensagem);
    }
}
