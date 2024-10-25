package com.suprevida.suprevida.repositories;

import com.suprevida.suprevida.entyties.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends CrudRepository<ProductEntity,Long> {
    ProductEntity findByName(String name);
}
