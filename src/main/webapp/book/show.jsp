<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Szczegóły książkę</h1>
${book.title}
${book.isbn}
<ul>
<c:forEach items="${book.authors}" var="author">
    <li>${author.firstName} - ${author.lastName}</li>
</c:forEach>
</ul>
</body>
</html>
