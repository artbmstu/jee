package ru.artbmstu.jee.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.ProductEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
@URLMapping(id = "admin=product-list", pattern = "/admin/admin-product-list", viewId = "/WEB-INF/faces/admin-product-list.xhtml")
public class AdminProductListController {


    @Inject
    private ProductRepository productRepository;

    private List<ProductEntity> products = new ArrayList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    public void reload() {
        products.clear();
        products.addAll(productRepository.findAll());
    }
}