<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="album" action="../update/${id}">
		<p>Nome: <form:input path="nome" /></p>
		<p>Interprete: <form:input path="interprete" /></p>
		<p><form:button>Editar</form:button></p>
		<p>${mensagem }</p>
	</form:form>


</body>
</html>