<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Buses</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
    <script>
        $( document ).ready(function() {
            $('#fechaIda').datepicker();
            $('#fechaVuelta').datepicker();
        });
    </script>
    
</head>
<body>
	<h1 style="text-align: center;"><spring:message code="titulo"/></h1>
	<br>
	<div class="container">
		<h2 style="text-align: center;"><spring:message code="bienvenida"/></h2>
	<div class="row">
    	<div class="col-8">
      
		<form:form modelAttribute="index">
		
			<div class="row">
			    <div class="col">
				    <div class="form-group">
					    <label for="exampleInputLugarSalida"><spring:message code="origen"/></label>
					    <form:input path="lugarSalida" class="form-control"/>
					  </div>   
				    </div>
			    <div class="col">
			      	<div class="form-group">
					    <label for="exampleInputLugarLlegada"><spring:message code="destino"/></label>
					    <form:input path="lugarLlegada" class="form-control"/>
					</div>   
			    </div>
			 </div>
			<br>
			 <div class="row">
			    <div class="col">
				    <div class="form-group">
					    <label for="exampleInputFechaIda"><spring:message code="fechaIdaFormulario"/></label>
					    <form:input type="text" path="idaFechaCalendar" data-date-format="dd/mm/yyyy" id="fechaIda" name="fechaIda" class="form-control"/>
					  </div>   
				    </div>
			    <div class="col">
			      	<div class="form-group">
					    <label for="exampleInputFechaVuelta"><spring:message code="fechaVueltaFormulario"/></label>
					    <form:input type="text" path="vueltaFechaCalendar" data-date-format="dd/mm/yyyy" id="fechaVuelta" name="fechaVuelta" class="form-control"/>
						<small id="vueltaHelp" class="form-text text-muted"><spring:message code="ayudaVuelta"/></small>

					</div>   
			    </div>
			 </div>
			<br>
			<div class="row">
			    <div class="col">
			  
			    </div>
			    <div class="col">
			    	<div class="form-group">
					    <label for="exampleInputFechaVuelta"><spring:message code="numViajeros"/></label>
					    <form:input path="numViajeros"  class="form-control"/>
					</div> <br>
					<button type="submit" class="btn btn-default btn-block"><spring:message code="buscar"/></button>
			    </div>
			    <div class="col">
			   
			    </div>
			  </div>
		</form:form>
		<br />
		<h3 style="text-align:center;"><spring:message code="proximosViajes"/></h3>
		<table class="table">
			<tr>
				<td><b><spring:message code="origen"/></b></td>
				<td><b><spring:message code="destino"/></b></td>
				<td><b><spring:message code="fechaIdaFormulario"/></b></td>
				<td><b><spring:message code="horaSalida"/></b></td>
			</tr>
			<c:forEach items="${viajeslist}" var="viaje">
				<tr>
					<td><c:out value="${viaje.lugarSalida}"></c:out></td>
					<td><c:out value="${viaje.lugarLlegada}"></c:out></td>
					<td><c:out value="${viaje.fechaViaje}"></c:out></td>
					<td><c:out value="${viaje.horaSalida}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
    </div>
    <div class="col-4">
    <a href="cancelarViaje"><spring:message code="cancelarViajeEnlace"/></a><br />
      <h2 style="text-align: center;"><spring:message code="destinosPopulares"/></h2>
		${destinospopulares} <br>
		
		<spring:message code="contadorVisitas"/><c:out value="${loginCounter.logins}"/>
    </div>
  </div>
		
		
	</div>
	
	
	

</body>
</html>