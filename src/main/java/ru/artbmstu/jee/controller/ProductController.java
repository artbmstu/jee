package ru.artbmstu.jee.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productBean")
@URLMapping(id = "product-list", pattern = "/product-list", viewId = "/WEB-INF/faces/product-list.xhtml")
@ViewScoped
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    private void init(){
        reload();
    }

    private void reload(){
        products.clear();
        products.addAll(productRepository.findAll());
    }

    public List<Product> getListProduct(){
        return products;
    }

    public void removeProductById(final String productId){
        productRepository.removeById(productId);
        reload();
    }
}
