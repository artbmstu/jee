<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style type="text/css" >
    .menu-categories a{
        color: white;
        font-size: 20px;
    }

    .menu-main {
        color: white;
        font-size: 30px;
        margin-left: 30px;
    }

    .menu {
        background-color: black;
        padding: 10px 0px 10px 0px;
    }
</style>

<head>
</head>
<body>
<div class="menu">
    <h1 class="menu-main">${param.get("menu")}></h1>
    <ul class="menu-categories">
        <li><a href="main">Main</a></li>
        <li><a href="catalog">Catalog</a></li>
        <li><a href="product">Product</a></li>
        <li><a href="cart">Cart</a></li>
        <li><a href="order">Order</a></li>
    </ul>
</div>
</body>
</html>