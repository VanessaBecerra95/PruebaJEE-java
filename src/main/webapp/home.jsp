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
	<header class="container">
		<nav>
			<ul>
				<li><strong>StartUp🚀</strong></li>
			</ul>
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Inicio </a></li>
				<li><a href="${pageContext.request.contextPath}/login">Cerrar
						Sesión</a></li>
			</ul>
		</nav>
	</header>

	<c:set var="usuario" value="${usuario}" />
	<main class="container">
		<h1>Bienvenido al sistema ${usuario.nombre}! 👋</h1>
		<article>
			<p>Nombre: ${usuario.nombre}</p>
			<p>Correo: ${usuario.correo}</p>
		</article>

		<div class="container">
			<h2>Listado de trabajadores</h2>

			<table class="striped" id="tblUsuarios">
				<thead data-theme="dark">
					<tr>
						<th>Id Usuario</th>
						<th>Nick</th>
						<th>Nombre</th>
						<th>Password</th>
						<th>Correo Electrónico</th>
						<th>Peso</th>
						<th>Dirección</th>
						<th>numeración</th>
						<th>Created at</th>
						<th>Update_at</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td><c:out value="${usuario.getDireccion().getUsuarioID()}"></c:out></td>
							<th><c:out value="${usuario.getNick()}"></c:out></th>
							<td><c:out value="${usuario.getNombre()}"></c:out></td>
							<td><c:out value="${usuario.getPassword()}"></c:out></td>
							<td><c:out value="${usuario.getCorreo()}"></c:out></td>
							<td><c:out value="${usuario.getPeso()}"></c:out></td>
							<td><c:out value="${usuario.getDireccion().getNombre()}"></c:out></td>
							<td><c:out value="${usuario.getDireccion().getNumeracion()}"></c:out></td>
							<td><c:out value="${usuario.getCreatedAt()}"></c:out></td>
							<td><c:out value="${usuario.getUpdatedAt()}"></c:out></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<jsp:include page="./footer.jsp"></jsp:include>

	<script src="https://kit.fontawesome.com/b5bbcbce64.js"
		crossorigin="anonymous"></script>
</body>
</html>