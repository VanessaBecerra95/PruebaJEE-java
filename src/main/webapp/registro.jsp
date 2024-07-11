<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de usuario</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pink.min.css" />
</head>
<body>
<jsp:include page="./nav.jsp"></jsp:include>
	<div class="container">
		<h1 class=pb-4>Registrar usuario</h1>
		<form class="form col-6 p-3"
			action="${pageContext.request.contextPath}/registro" method="post">
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					placeholder="Nombre completo">
			</div>
			<div class="mb-3">
				<label for="correo" class="form-label">Correo</label> <input
					type="email" class="form-control" id="correo" name="correo"
					placeholder="correo@ejemplo.com">
			</div>
			<div class="mb-3">
				<label for="nick" class="form-label">Nick</label> <input type="text"
					class="form-control" id="nick" name="nick" placeholder="Juanito123">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Ingrese clave segura">
			</div>
			<div class="mb-3">
				<label for="peso" class="form-label">Peso</label> <input
					type="number" class="form-control" id="peso" name="peso"
					placeholder="Indique el número de su peso" min="0">
			</div>
			<button type="submit" class="btn btn-primary">
				<i class="fa-solid fa-floppy-disk"></i> Guardar
			</button>
			<input type="reset" />
		</form>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
	<script src="https://kit.fontawesome.com/b5bbcbce64.js"
		crossorigin="anonymous"></script>
</body>
</html>