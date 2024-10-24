package com.suprevida.suprevida.controlles;

import com.suprevida.suprevida.commons.BaseController;
import com.suprevida.suprevida.core.ResponseJson;
import com.suprevida.suprevida.entyties.UserEntity;
import com.suprevida.suprevida.inputs.UserInput;
import com.suprevida.suprevida.useCases.RegisterUseCase;
import com.suprevida.suprevida.useCases.GetAllUsersUseCase;

import com.suprevida.suprevida.useCases.UserByLoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UsersController extends BaseController {

    @Autowired
    private RegisterUseCase registerUseCase;
    @Autowired
    private GetAllUsersUseCase getAllUsersUseCase;


    @Autowired
    private UserByLoginUseCase userByLoginUseCase;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserInput userInput){
        var outputRegisterUseCase =registerUseCase.execute(userInput);
        if(outputRegisterUseCase){
            return ResponseJson.json(response, HttpStatus.CREATED);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> users(){
        Iterable<UserEntity> outputGetAllUsersUseCase = getAllUsersUseCase.execute();
        response.put("users", outputGetAllUsersUseCase);
        return ResponseJson.json(response, HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> user(@RequestBody  UserInput userInput){
        UserEntity outputUser = userByLoginUseCase.execute(userInput.login());


        response.put("user", outputUser);
        return ResponseJson.json(response, HttpStatus.OK);
    }


}
