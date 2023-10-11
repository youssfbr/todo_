package com.github.youssfbr.todolist.filter;

import com.github.youssfbr.todolist.entities.User;
import com.github.youssfbr.todolist.repositories.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class FilterTaskAuth extends OncePerRequestFilter {

    private final IUserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Pegar a autenticacao (usuario e senha)
        String authorization = request.getHeader("Authorization");
        String authEncoded = authorization.substring("Basic".length()).trim();
        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        String authString = new String(authDecode);
        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        // Validar usuario
        User user = userRepository.findByUsername(username);
        if (user == null) {
            response.sendError(401);
        }
        else {

            // Validar senha

            filterChain.doFilter(request, response);
        }
    }
}
