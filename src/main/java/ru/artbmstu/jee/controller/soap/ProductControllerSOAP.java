package ru.artbmstu.jee.controller.soap;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.api.WebServiceProduct;
import ru.artbmstu.jee.dto.ResultDTO;
import ru.artbmstu.jee.dto.SuccessDTO;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ru.artbmstu.jee.api.WebServiceProduct", serviceName = "ProductSoap")
public class ProductControllerSOAP implements WebServiceProduct {

    @Inject
    private ProductRepository productRepository;

    @Override
    public ResultDTO ping(){
        return new SuccessDTO();
    }
}