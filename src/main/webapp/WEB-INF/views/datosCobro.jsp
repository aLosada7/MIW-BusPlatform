<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Buses</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
</head>
<body>
<div class="container">
	<h1 style="text-align: center;">Viajes Bus</h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="cobroPresentacion"/></h2>
	<form:form modelAttribute="datosCobro">
		<div class="form-group">
		    <label for="exampleInputNombre"><spring:message code="nombre"/></label>
		    <form:input path="nombre" class="form-control"/>
		</div> 
		<br>
		<div class="form-group">
		    <label for="exampleInputApellidos"><spring:message code="apellidos"/></label>
		    <form:input path="apellidos" class="form-control"/>
		</div>
		<br>
		<spring:message code="tidentificacion"/>
		<form:select path="tipoIdentificacion">
			<form:option value="nif"/> 
			<form:option value="pasaporte"/> 
			<form:option value="nie"/>
		</form:select><br>
		<br>
		<div class="form-group">
		    <label for="exampleInputIdentificacion"><spring:message code="identificacion"/></label>
		    <form:input path="identificacion" class="form-control"/>
		</div>
		<br>
		<div class="form-group">
		    <label for="exampleInputEmail1"><spring:message code="email"/></label>
		    <form:input path="email" class="form-control"/>
		</div>
		<br>
		<input type="submit" value="Reservar"/>
	</form:form>
	
	<p style="color: red;">
		<c:out value="${message}" />
	</p>
	
</div>
</body>
</html>