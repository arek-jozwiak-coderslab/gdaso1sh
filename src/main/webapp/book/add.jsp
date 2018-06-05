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
<h1>Dodaj książkę</h1>
<form:form method="post" modelAttribute="book">
    <jsp:include page="form_include.jsp"/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
