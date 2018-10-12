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
import java.util.Collection;

@WebServlet(urlPatterns = "/product-list")
public class ProductListServlet extends HttpServlet {

    private static final String PRODUCTS = "products";

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Collection<Product> products = productRepository.findAll();
        request.setAttribute(PRODUCTS, products);
        request.getRequestDispatcher("WEB-INF/views/product-list.jsp").forward(request, response);
    }
}
