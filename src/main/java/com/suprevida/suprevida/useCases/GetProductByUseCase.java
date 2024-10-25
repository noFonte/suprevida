package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.ProductEntity;
import com.suprevida.suprevida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductByUseCase {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity execute(Long id){
        return productRepository.findById(id).get();
        
    }
}
