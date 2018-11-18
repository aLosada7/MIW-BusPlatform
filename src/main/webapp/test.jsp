<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> numList = new ArrayList<String>();
	numList.add("one");
	numList.add("two");
	numList.add("three");
	request.setAttribute("numList", numList);
%>
<html>
<body>
	<c:out value='${requestScope["numList"]}' /><br/>
	<c:out value='${requestScope.numList}'/>
</body>
</html>