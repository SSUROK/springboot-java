<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.gb.hw7.entity.Product" %>
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
    <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<table>
    <%int k = 0;%>
    <tr>
        <jsp:useBean id="cart" scope="request" type="java.util.HashMap"/>
        <c:forEach var="product" items="${cart}">
            <td>
                <c:url var="viewProduct" value="/product/id= + ${product.key.id}">
                </c:url>
                Name: <a href="${viewProduct}">${product.key.title}</a><br>
                ID: ${product.key.id}<br>
                Quantity: ${product.value}<br>
                Cost: ${product.key.cost}*${product.value} <br>
            </td>
        </c:forEach>
    </tr>
</table>
<br>
<c:url var="productList" value="/product/all">
</c:url>
<a href=${productList}> Products</a>
</body>
</html>
