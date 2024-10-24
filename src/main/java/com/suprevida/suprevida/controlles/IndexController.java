package com.suprevida.suprevida.controlles;

import com.suprevida.suprevida.commons.BaseController;
import com.suprevida.suprevida.core.ResponseJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class IndexController extends BaseController {
    @GetMapping({"/","/index"})
    public ResponseEntity<Map<String, Object>> Index(){
        response.put("api","Suprevida - Versão 1");
        response.put("sobre","Gerencia Cadastro de Produtos.");
        return ResponseJson.json(response, HttpStatus.OK);
    }

}
