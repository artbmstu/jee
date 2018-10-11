package ru.artbmstu.jee.repository;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ProductRepositoryBean implements ProductRepository {

    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new Product("Demo product"));
    }

    @Override
    public Collection<Product> findAll() {
        return products.values();
    }

    @Override
    public Product findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return products.get(id);
    }

    @Override
    public Collection<Product> findByIds(final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        final Collection<Product> result = new LinkedHashSet<>();
        ids.forEach(id -> {
            if (id == null || id.isEmpty()) return;
            final Product product = findById(id);
            if (product == null) return;
            result.add(product);
        });
        return result;
    }

    @Override
    public Product merge(final Product product) {
        if (product == null) return null;
        final String id = product.getId();
        if (id == null || id.isEmpty()) return  null;
        products.put(id, product);
        return product;
    }

    @Override
    public Collection<Product> merge(final Collection<Product> products){
        if (products == null || products.isEmpty()) return Collections.emptySet();
        final Collection<Product> result = new LinkedHashSet<>();
        products.forEach(product -> {
            if (product == null) return;
            result.add(merge(product));
        });
        return result;
    }

    @Override
    public void removeById(final String id) {
        if (id == null || id.isEmpty()) return;
        if (!products.containsKey(id)) return;
        products.remove(id);
    }

    @Override
    public void removeByIds(final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        ids.forEach(this::removeById);
    }

    @Override
    public void remove(final Collection<Product> products) {
        if (products == null || products.isEmpty()) return;
        products.forEach(product -> {
            if (product == null) return;
            this.products.remove(product.getId());
        });
    }

    @Override
    public void removeAll() {
        products.clear();
    }
}
