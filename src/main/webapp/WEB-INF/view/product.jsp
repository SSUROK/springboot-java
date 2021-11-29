<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page import="ru.gb.springbootjava.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: ilavinogradov
  Date: 25.11.2021
  Time: 03:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product.title}</title>
</head>
<body>
<h1>Product</h1>
  <h3> Title: ${product.title} </h3>
  <h4> ID: ${product.id} </h4>
  <h4> Cost:  ${product.cost} </h4>
<br>
<c:url var="deleteProduct" value="/product/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${deleteProduct}"> Delete</a>
<c:url var="editProduct" value="/product/edit">
    <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${editProduct}"> Edit</a>
</body>
</html>
