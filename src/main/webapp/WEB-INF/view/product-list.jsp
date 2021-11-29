<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.gb.springbootjava.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ilavinogradov
  Date: 25.11.2021
  Time: 02:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List</h1>
    <table>
        <%int k = 0;%>
        <tr>
        <jsp:useBean id="productsList" scope="request" type="java.util.List"/>
        <c:forEach var="product" items="${productsList}">
            <td>
                <c:url var="viewProduct" value="/product/id= + ${product.id}">
                </c:url>
                Name: <a href="${viewProduct}">${product.title}</a><br>
                ID: ${product.id}<br>
                Cost: ${product.cost} <br>
                <c:url var="addToCart" value="/cart/add/id= + ${product.id}">
                </c:url>
                <a href="${addToCart}"> Add to cart</a>
            </td>
            </c:forEach>
        </tr>
    </table>
<br>
<c:url var="editProduct" value="/product/create">
    <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${editProduct}"> Create</a>
<c:url var="cart" value="/cart/all">
</c:url>
<a href=${cart}> Cart</a>
</body>
</html>
