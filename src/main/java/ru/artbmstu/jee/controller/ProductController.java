package ru.artbmstu.jee.controller;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.ProductEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ManagedBean
@ViewScoped
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    public void create() {
        final ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID().toString());
        productEntity.setName("name");
        productEntity.setDescription("description");
        productRepository.persist(productEntity);
    }

    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    public ProductEntity findById(String id) {
        return productRepository.findById(id);
    }

    public ProductEntity merge(ProductEntity productEntity) {
        return productRepository.merge(productEntity);
    }

    public void removeAll() {
        productRepository.removeAll();
    }

    public void removeById(String id) {
        productRepository.removeById(id);
    }

    public void remove(ProductEntity productEntity) {
        productRepository.removeProductEntity(productEntity);
    }
}