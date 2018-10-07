package ru.artbmstu.jee.utility;

public class HeadUtility {

    public static final String mainName = "<h1>Main</h1>";
    public static final String catalogName = "<h1>Catalog</h1>";
    public static final String productName = "<h1>Product</h1>";
    public static final String cartName = "<h1>Cart</h1>";
    public static final String orderName = "<h1>Order</h1>";

    public static String makeHead(){
        return "<ul><li><a href='main'>Main</a></li>" +
                "<li><a href='catalog'>Catalog</a></li>" +
                "<li><a href='product'>Product</a></li>" +
                "<li><a href='cart'>Cart</a></li>" +
                "<li><a href='order'>Order</a></li></ul>";
    }
}
