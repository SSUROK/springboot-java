<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ilavinogradov
  Date: 25.11.2021
  Time: 04:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Create product</h1>
<%--@elvariable id="product" type="ru.gb.beans.entity.Product"--%>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:input path="title"/>
    Cost: <form:input path="cost"/>

    <input type="submit" value="submit">
</form:form>
</body>
</html>
