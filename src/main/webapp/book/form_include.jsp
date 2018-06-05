<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<label for="title">Tytuł</label>
<form:input path="title" />
<label for="isbn">isbn</label>
<form:hidden path="id" />
<form:input path="isbn" />
<label for="publisher.id">publisher</label>
<form:select path="publisher.id" itemValue="id" itemLabel="fullName" items="${publishers}" />
<form:checkboxes path="authors" itemValue="id" itemLabel="lastName" items="${authors}"/>