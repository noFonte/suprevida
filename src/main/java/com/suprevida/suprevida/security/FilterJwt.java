package com.suprevida.suprevida.security;

import com.suprevida.suprevida.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class FilterJwt extends OncePerRequestFilter {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token;
        var authHeader=request.getHeader("Authorization");
        if(authHeader !=null){
            token = authHeader.replace("Bearer","");
            var subject =tokenService.getSubject(token);
            var user =  userRepository.findByLogin(subject);
            var authentication =  new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }
}

