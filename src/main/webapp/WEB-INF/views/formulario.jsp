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

	<form:form method="POST" modelAttribute="album" action="cadastro">
		<p>Nome: <form:input path="nome" /></p>
		<p>Interprete: <form:input path="interprete" /></p>
		<p><form:button>Enviar</form:button></p>
		<p>${mensagem }</p>
	</form:form>
	
	<p>
		<table>
			<thead>
				<tr>
					<th>NOME</th>
					<th>INTERPRETE</th>
					<th>AÇÃO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="album" items="${albums}">
					<tr>
						<td> ${album.nome}</td>
						<td> ${album.interprete}</td>
						<td> 
							<a href="editar/${albums.indexOf(album)}">Editar</a>
							<a href="excluir/${albums.indexOf(album)}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</p>
</body>
</html>