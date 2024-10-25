package com.suprevida.suprevida.useCases;

import com.suprevida.suprevida.entyties.ProductEntity;
import com.suprevida.suprevida.inputs.ProductInput;
import com.suprevida.suprevida.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductByUseCase {
    @Autowired
    private ProductRepository productRepository;


    public ProductEntity execute(Long id, ProductInput productInput) {
        ProductEntity outputProductData = productRepository.findById(id).get();
        if(outputProductData!=null){
            var outputData =  productRepository.save(new ProductEntity(id,productInput.name(),productInput.description(),productInput.price()));
            if(outputData.getId() !=null) return productRepository.findById(id).get();
        }
        return null;
    }
}
