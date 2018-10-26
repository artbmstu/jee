package ru.artbmstu.jee.controller.rest;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.dto.FailDTO;
import ru.artbmstu.jee.dto.ProductDTO;
import ru.artbmstu.jee.dto.ResultDTO;
import ru.artbmstu.jee.dto.SuccessDTO;
import ru.artbmstu.jee.entity.ProductEntity;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@WebService
@Path("/product")
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    @GET
    @WebMethod
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO ping(){
        return new SuccessDTO();
    }

    @GET
    @WebMethod
    @Path("/getList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getList(){
        return productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @GET
    @WebMethod
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO create(){
        final ProductEntity product = productRepository.create();
        return new ProductDTO(product);
    }

    @GET
    @WebMethod
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getById(@QueryParam("id") @WebParam(name = "id", partName = "id") final String id){
        final ProductEntity product = productRepository.getById(id);
        if (product == null) return null;
        return new ProductDTO(product);
    }

    @GET
    @WebMethod
    @Path("/removeById")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO removeById(@QueryParam("id") @WebParam(name = "id", partName = "id") final String id){
        try {
            productRepository.removeById(id);
            return new SuccessDTO();
        } catch (final Exception e){
            return new FailDTO(e);
        }
    }

}