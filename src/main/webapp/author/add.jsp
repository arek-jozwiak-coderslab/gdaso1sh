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
<h1>Dodaj authora</h1>
<form:form method="post" modelAttribute="author">
    <form:input path="firstName" />
    <form:input path="lastName" />
    <form:input path="yearOfBirth" />
    <form:errors path="yearOfBirth" cssClass="error"  />
    <%--<input type="number" min="1900" max="2099" step="1" value="2016" />--%>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
