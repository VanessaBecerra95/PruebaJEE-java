<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login de usuario</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pink.min.css" />
</head>
<body>
<jsp:include page="./nav.jsp"></jsp:include>
	<main class="container">
		<h1 class=pb-4>Login</h1>
		<form class="form container" action="${pageContext.request.contextPath}/login" method="post">
			<fieldset class="grid">
				<input name="correo" placeholder="correo" aria-label="correo"
					autocomplete="correo" /> <input type="password"
					name="password" placeholder="Password" aria-label="Password"
					autocomplete="current-password" /> <input type="submit"
					value="Log in" />
			</fieldset>
		</form>
	</main>
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>