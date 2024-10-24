package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.UserEntity;
import com.suprevida.suprevida.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserByLoginUseCase {
    @Autowired
    private UserRepository userRepository;


    public UserEntity execute(String login){
        return userRepository.findByLogin(login);
    }

}
