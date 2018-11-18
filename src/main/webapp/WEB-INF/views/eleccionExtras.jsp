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
	<h2 style="text-align: center;">Eleccion extras</h2>
	${idida} ${idvuelta}
	<form:form modelAttribute="eleccionExtras">
		<spring:message code="bicicleta"/>
		<form:select path="extraBicicleta">
			<form:option value="true"/> 
			<form:option value="false"/>
	    </form:select>
		<br>
		<spring:message code="mascota"/>
		<form:select path="extraMascota">
			<form:option value="true"/> 
			<form:option value="false"/>
	    </form:select>
	    <br>
		<spring:message code="surf"/> 
		<form:select path="extraSurf">
			<form:option value="true"/> 
			<form:option value="false"/>
	    </form:select>
	    <br>
		<spring:message code="ski"/>
		<form:select path="extraSkis">
			<form:option value="true"/> 
			<form:option value="false"/>
	    </form:select>
	    <br><br>
		<spring:message code="seguro"/>
		<form:select path="seguro">
			<form:option value="true"/> 
			<form:option value="false"/>
	    </form:select>
	    <br>
		<input type="submit" />
	</form:form>
	
</div>
</body>
</html>