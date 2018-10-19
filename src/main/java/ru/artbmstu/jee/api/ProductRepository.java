package ru.artbmstu.jee.api;

import ru.artbmstu.jee.entity.ProductEntity;

import javax.ejb.LocalBean;
import java.util.List;

@LocalBean
public interface ProductRepository {

    List<ProductEntity> findAll();

    ProductEntity getById(String id);

    ProductEntity findById(String id);

    ProductEntity persist(ProductEntity productEntity);

    ProductEntity merge(ProductEntity productEntity);

    void removeProductEntity(ProductEntity productEntity);

    void removeById(String id);

    void removeAll();
}
