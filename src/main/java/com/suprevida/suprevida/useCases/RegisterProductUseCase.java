package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.ProductEntity;
import com.suprevida.suprevida.inputs.ProductInput;
import com.suprevida.suprevida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity execute(ProductInput productInput) {
        ProductEntity outputProductData = productRepository.findByName(productInput.name());
        if(outputProductData==null){
            var outputData =  productRepository.save(new ProductEntity( productInput.name(),productInput.description(),productInput.price()));
            if(outputData.getId() !=null) return productRepository.findByName(productInput.name());
        }
        return null;
    }
}
