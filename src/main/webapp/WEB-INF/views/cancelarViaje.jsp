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
	<h1 style="text-align: center;">Viajes Bus</h1>
	<br>
	<h2 style="text-align: center;">Cancelar viaje</h2>
	<form:form modelAttribute="cancelarViaje">
		<div class="form-group">
		    <label for="exampleInputIdentificadorReserva"><spring:message code="idenReserva"/></label>
		    <form:input path="identificadorReserva" class="form-control"/>
		</div>
		<br />
		<div class="form-group">
		    <label for="exampleInputEmail"><spring:message code="email"/></label>
		    <form:input path="email" class="form-control"/>
		</div>
		<br />
		<form:checkbox path="confirmarCancelacion"/><spring:message code="cancelarCheck"/> <br />
		<input type="submit" value="Completar la cancelación" />
	</form:form>
	

</body>
</html>