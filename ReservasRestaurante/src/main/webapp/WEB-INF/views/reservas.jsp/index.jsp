<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurante Puglia Galassini</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div>
		<h1>Faça a sua Reserva aqui</h1>
		<div>
			<a href=<c:url value="/eventos/listar"/>> <button class="btn btn-primary">Lista de Eventos</button></a>
		</div>
		<br>
		<br>
		<div>
			<a href=<c:url value="/eventos/incluir"/>><button class="btn btn-primary">Cadastro de Eventos</button></a>
		</div>
		
	</div>
</body>
</html>