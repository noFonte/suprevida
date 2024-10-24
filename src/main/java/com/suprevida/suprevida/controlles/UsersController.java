package com.suprevida.suprevida.controlles;

import com.suprevida.suprevida.commons.BaseController;
import com.suprevida.suprevida.core.ResponseJson;
import com.suprevida.suprevida.inputs.UserInput;
import com.suprevida.suprevida.useCases.RegisterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UsersController extends BaseController {

    @Autowired
    private RegisterUseCase registerUseCase;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserInput userInput){
        var outputRegisterUseCase =registerUseCase.execute(userInput);
        if(outputRegisterUseCase){
            return ResponseJson.json(response, HttpStatus.CREATED);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }


}
