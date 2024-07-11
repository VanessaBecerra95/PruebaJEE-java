<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StartUp</title>
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.pink.min.css"
/>
</head>
<body>
<jsp:include page="./nav.jsp"></jsp:include>
	<main class="container">
	 <h1>Bienvenido a StartUp</h1>
    <form action="${pageContext.request.contextPath}/registro">
        <input type="submit" value="Registro">
    </form>
    <form action="${pageContext.request.contextPath}/login">
        <input type="submit" value="Login">
    </form>
    </main>
    <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>