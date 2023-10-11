package com.github.youssfbr.todolist.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Pegar a autenticacao (usuario e senha)
        String authorization = request.getHeader("Authorization");

        System.out.println("Authorization");
        System.out.println(authorization);

        String authEncoded = authorization.substring("Basic".length()).trim();
        System.out.println(authEncoded);

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        System.out.println(authDecode);
        String authString = new String(authDecode);
        System.out.println(authString);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];
        System.out.println(username);
        System.out.println(password);
        // Validar usuario

        // Validar senha

        filterChain.doFilter(request, response);


    }
}
