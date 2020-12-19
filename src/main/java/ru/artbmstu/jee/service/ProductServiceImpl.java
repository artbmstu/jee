package ru.artbmstu.jee.service;

import ru.artbmstu.jee.api.Async;
import ru.artbmstu.jee.api.ProductService;

import javax.enterprise.inject.Alternative;

@Async
@Alternative
public class ProductServiceImpl implements ProductService {
}