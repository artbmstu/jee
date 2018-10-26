package ru.artbmstu.jee.api;

import ru.artbmstu.jee.dto.ResultDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceProduct {

    @WebMethod
    ResultDTO ping();
}