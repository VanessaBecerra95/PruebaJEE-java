<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pink.min.css" />
<title>Home</title>
</head>
<body>
	<jsp:include page="./nav.jsp"></jsp:include>
	
	<c:set var="usuario" value="${usuario}" />
	<main class="container">
		<h1>Bienvenido al sistema! 👋</h1>
		<article>
			<p>Nombre: ${usuario.nombre}</p>
			<p>Correo: ${usuario.correo}</p>
		</article>
	</main>
	<jsp:include page="./footer.jsp"></jsp:include>

</body>
</html>