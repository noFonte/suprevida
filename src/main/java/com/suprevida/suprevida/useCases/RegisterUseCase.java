package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.UserEntity;
import com.suprevida.suprevida.inputs.UserInput;
import com.suprevida.suprevida.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {
    @Autowired
    private UserRepository userRepository;


    public boolean execute(UserInput userInput) {
        UserEntity userData = userRepository.findByLogin(userInput.login());
        if(userData==null){
            var outputData =  userRepository.save(new UserEntity(userInput.login(),userInput.password()));
            if(outputData.getId() !=null) return true;
        }
        return false;
    }
}
