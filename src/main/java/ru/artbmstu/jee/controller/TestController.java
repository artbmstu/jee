package ru.artbmstu.jee.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.artbmstu.jee.api.Async;
import ru.artbmstu.jee.api.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@URLMapping(id = "test", pattern = "/test", viewId = "/WEB-INF/faces/test.xhtml")
public class TestController {

    @Inject
    private ProductService productService;

    @Inject @Default
    private ProductService productServiceDefault;

    @Inject @Async
    private ProductService productServiceAsync;

    public String getProductServiceClassName(){
        return productService.getClass().getSimpleName();
    }

    public String getProductServiceDefaultClassName(){
        return productServiceDefault.getClass().getSimpleName();
    }

    public String getProductServiceAsyncClassName(){
        return productServiceAsync.getClass().getSimpleName();
    }
}