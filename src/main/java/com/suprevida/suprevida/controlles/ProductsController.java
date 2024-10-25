package com.suprevida.suprevida.controlles;


import com.suprevida.suprevida.commons.BaseController;
import com.suprevida.suprevida.core.ResponseJson;
import com.suprevida.suprevida.inputs.ProductInput;

import com.suprevida.suprevida.useCases.*;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductsController extends BaseController {

    @Autowired
    private RegisterProductUseCase registerProcuctUseCase;
    @Autowired
    private GetProductByUseCase getProductByUseCase;

    @Autowired
    private GetProductAllUseCase getProductAllUseCase;

    @Autowired
    private UpdateProductByUseCase updateProductByUseCase;


    @Autowired
    private DeleteProductByUseCase deleteProductByUseCase;



    @PostMapping("/product")
    public ResponseEntity<Map<String, Object>> product(@RequestBody ProductInput productInput){
        var outputRegisterUseCase =registerProcuctUseCase.execute(productInput);
        if(outputRegisterUseCase != null){
            response.put("product",outputRegisterUseCase);
            return ResponseJson.json(response, HttpStatus.CREATED);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Map<String, Object>> product(@PathVariable(value = "id") Long id){
        var outputGetProductByUseCase =getProductByUseCase.execute(id);
        if(outputGetProductByUseCase != null){
            response.put("product",outputGetProductByUseCase);
            return ResponseJson.json(response, HttpStatus.OK);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> products(){
        var outputGetProductAllUseCase =getProductAllUseCase.execute();
        if(outputGetProductAllUseCase != null){
            response.put("products",outputGetProductAllUseCase);
            return ResponseJson.json(response, HttpStatus.OK);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Map<String, Object>> productUpdate(@PathVariable(value = "id") Long id,@RequestBody ProductInput productInput){
        var outputUpdateProductByUseCase =updateProductByUseCase.execute(id,productInput);
        if(outputUpdateProductByUseCase != null){
            response.put("product",outputUpdateProductByUseCase);
            return ResponseJson.json(response, HttpStatus.OK);
        }
        return ResponseJson.json(response, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Object>> productDelete(@PathVariable(value = "id") Long id){
        var outputGetProductByUseCase =deleteProductByUseCase.execute(id);
        if(outputGetProductByUseCase){
            return ResponseJson.json(response, HttpStatus.OK);
        }
        return ResponseJson.json(response, HttpStatus.NOT_MODIFIED);
    }



}
