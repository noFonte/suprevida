package com.suprevida.suprevida.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Objects;

public class ResponseJson {

    public static ResponseEntity<Map<String, Object>> json(Map<String, Object> response, HttpStatus httpCode){
        return new ResponseEntity<>(response, httpCode);
    }
}
