<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" modelAttribute="moeda">
		<p>Dolar: <form:input path="dolar" /></p>
		<p>Taxa: <form:input path="taxa" /></p>
		<p><form:button>Enviar</form:button></p>
		<p>${mensagem}</p>
		
		<p>${mensagem2}</p>		
		 
	</form:form>
	
</body>
</html>