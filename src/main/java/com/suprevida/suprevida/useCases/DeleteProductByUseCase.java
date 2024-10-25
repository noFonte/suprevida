package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.ProductEntity;
import com.suprevida.suprevida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductByUseCase {
    @Autowired
    private ProductRepository productRepository;



    public boolean execute(Long id) {

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
