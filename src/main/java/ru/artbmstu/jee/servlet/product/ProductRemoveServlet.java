package ru.artbmstu.jee.servlet.product;

import ru.artbmstu.jee.api.ProductRepository;
import ru.artbmstu.jee.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-remove")
public class ProductRemoveServlet extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Product product = new Product();
        product.setName("Remove product");
        productRepository.merge(product);
        response.sendRedirect("product-list");
    }
}
