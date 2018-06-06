<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
<label for="title">Tytuł</label>
<form:input path="title" />
<form:errors path="title" cssClass="error"  />
</div>
<div>
<label for="isbn">isbn</label>
<form:hidden path="id" />
<form:input path="isbn" />
</div>
<div>
<label for="publisher.id">publisher</label>
<form:select path="publisher.id" itemValue="id" itemLabel="fullName" items="${publishers}" />
</div>
<div>
    Autorzy
<form:checkboxes path="authors" itemValue="id" itemLabel="lastName" items="${authors}"/>
</div>