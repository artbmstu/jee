<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link href="<c:url value="WEB-INF/css/bootstrap.min.css" />" rel="stylesheet">
<jsp:include page="WEB-INF/views/menu-prefix.jsp">
    <jsp:param name="menu" value="PRODUCT"/>
</jsp:include>

<style>
    .product-item {
        width: 400px;
        margin: 20px 20px 20px 20px;
        outline: 1px solid black;
    }

    .to-cart {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
</style>
<head>
    <title>Product</title>
</head>
<body>
<div class="product-item">
    <a href="images/lg43uj639v.jpeg" target="_blank"><img src="images/lg43uj639v.jpeg" width="400"></a>
    <h3>Телевизор Ultra HD LED LG 43UJ639V</h3>
    <button class="to-cart" type="submit" value="to-cart">Add to cart</button>
</div>
</body>
</html>