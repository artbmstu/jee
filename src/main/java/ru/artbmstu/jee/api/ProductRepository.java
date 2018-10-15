package ru.artbmstu.jee.api;

import ru.artbmstu.jee.entity.Product;

import java.util.Collection;

public interface ProductRepository {

    Collection<Product> findAll();

    Product findById(String id);

    Collection<Product> findByIds(Collection<String> ids);

    Product merge(Product product);

    Collection<Product> merge(Collection<Product> products);

    void removeById(String id);

    void removeByIds(Collection<String> ids);

    void remove(Collection<Product> products);

    void removeAll();
}
