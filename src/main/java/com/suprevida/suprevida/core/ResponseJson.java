package com.suprevida.suprevida.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseJson {

    public static ResponseEntity<Map<String, String>> json(Map<String, String> response,HttpStatus httpCode){
        return new ResponseEntity<>(response, httpCode);
    }
}
