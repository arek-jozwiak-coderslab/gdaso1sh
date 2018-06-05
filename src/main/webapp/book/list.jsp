<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 05.06.18
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista książek</h1>
<a href="<c:url value="/book/add"/>">Dodaj</a>
<table>
    <tr>
        <th>Id</th>
        <th>title</th>
        <th>isbn</th>
        <th>publisher</th>
        <th>Akacja</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.isbn}</td>
            <td>${book.publisher.firstName}</td>
            <td>
                <a href="<c:url value="/book/delete/${book.id}"/>">Usuń</a>
                <a href="<c:url value="/book/update/${book.id}"/>">Edytuj</a>
                <a href="<c:url value="/book/show/${book.id}"/>">Pokaż</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
