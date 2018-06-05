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
<c:forEach items="${authors}" var="author">
    <c:out value="${author.firstName}"/>
    <c:out value="${author.lastName}"/>
</c:forEach>

<form:form method="post" modelAttribute="student">
    <form:input path="firstName" />
    <form:input path="lastName" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>
