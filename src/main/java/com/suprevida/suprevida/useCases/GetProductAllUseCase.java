package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.ProductEntity;
import com.suprevida.suprevida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductAllUseCase {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductEntity> execute(){
        return productRepository.findAll();

    }

}
