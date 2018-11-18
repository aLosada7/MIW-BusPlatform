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
    <script>
	    function printPage() {
	        window.print();
	    }
    </script>
</head>
<body>
<div class="container">
	<h1 style="text-align: center;">Viajes Bus</h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="mensajeEleccionBus"/></h2>
	<button type="button" class="btn btn-primary" onclick="printPage()">Imprimir hoja</button>
	<form id="enviarCorreo" action="${correoUrl}" method="post">
        <input type="submit" value="Enviar Correo" />
 	</form>
	
	<h4><spring:message code="introduccionReserva"/></h4>
	<spring:message code="ida"/> ${ida.lugarSalida} - ${ida.lugarLlegada} : ${ida.fechaViaje} ${ida.horaSalida}<br>
	<spring:message code="vuelta"/> ${vuelta.lugarSalida} - ${vuelta.lugarLlegada} : ${vuelta.fechaViaje} ${vuelta.horaSalida}
	
	<table class="table">
			<tr>
				<td><b><spring:message code="numViajeros"/></b></td>
				<td>${resumen.numViajeros}</td>
			</tr>
			<tr>
				<td><b><spring:message code="nombre"/></b></td>
				<td>${resumen.nombre}</td>
			</tr>
			<tr>
				<td><b><spring:message code="apellidos"/></b></td>
				<td>${resumen.apellidos}</td>
			</tr>
			<tr>
				<td><b><spring:message code="email"/></b></td>
				<td>${resumen.email}</td>
			</tr>
			<tr>
				<td><b><spring:message code="equipajeExtra"/> <spring:message code="bicicleta"/></b></td>
				<td>${resumen.extraBicicleta}</td>
			</tr>
			<tr>
				<td><b><spring:message code="equipajeExtra"/> <spring:message code="mascota"/></b></td>
				<td>${resumen.extraMascota}</td>
			</tr>
			<tr>
				<td><b><spring:message code="equipajeExtra"/> <spring:message code="surf"/></b></td>
				<td>${resumen.extraSurf}</td>
			</tr>
			<tr>
				<td><b><spring:message code="equipajeExtra"/> <spring:message code="ski"/></b></td>
				<td>${resumen.extraSkis}</td>
			</tr>
			<tr>
				<td><b><spring:message code="equipajeExtra"/> <spring:message code="seguro"/></b></td>
				<td>${resumen.seguro}</td>
			</tr>
	</table><br>
	<p style="text-align:center;"><a href="index"><spring:message code="return"/></a></p>
</div>
</body>
</html>