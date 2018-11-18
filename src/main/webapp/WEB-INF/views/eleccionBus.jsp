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
	<img src="${imagenDestinoIda}"  height=200 width=400 alt="Destino">
	<form:form modelAttribute="eleccionBus">
		<table class="table">
			<tr>
				<td><b><spring:message code="origen"/></b></td>
				<td><b><spring:message code="destino"/></b></td>
				<td><b><spring:message code="horaSalida"/></b></td>
				<td><b><spring:message code="horaLlegada"/></b></td>
				<td><b>Precio</b></td>
				<td><b><spring:message code="yourChoice"/></b></td>
				
			</tr>
			<c:forEach items="${viajesporfiltrolistida}" var="viaje">
				<tr>
					<td><c:out value="${viaje.lugarSalida}"></c:out></td>
					<td><c:out value="${viaje.lugarLlegada}"></c:out></td>				
					<td><c:out value="${viaje.horaSalida}"></c:out></td>
					<td><c:out value="${viaje.horaLlegada}"></c:out></td>
					<td><c:out value="${viaje.precio}"></c:out></td>
					<td><form:radiobutton path="identificadorViajeIda" value="${viaje.idViaje}"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<img src="${imagenDestinoVuelta}" height=200 width=400 alt="Destino">
		<table class="table">
			<tr>
				<td><b><spring:message code="origen"/></b></td>
				<td><b><spring:message code="destino"/></b></td>
				<td><b>Fecha viaje</b></td>
				<td><b><spring:message code="horaSalida"/></b></td>
				<td><b><spring:message code="horaLlegada"/></b></td>
				<td><b><spring:message code="yourChoice"/></b></td>
			</tr>
			<c:forEach items="${viajesporfiltrolistvuelta}" var="viaje">
				<tr>
					<td><c:out value="${viaje.lugarSalida}"></c:out></td>
					<td><c:out value="${viaje.lugarLlegada}"></c:out></td>
					<td><c:out value="${viaje.fechaViaje}"></c:out></td>
					<td><c:out value="${viaje.horaSalida}"></c:out></td>
					<td><c:out value="${viaje.horaLlegada}"></c:out></td>
					<td><form:radiobutton path="identificadorViajeVuelta" value="${viaje.idViaje}"/></td>
				</tr>
			</c:forEach>
		</table>
	
	
		<input type="submit" />
	</form:form>
	
</div>
</body>
</html>