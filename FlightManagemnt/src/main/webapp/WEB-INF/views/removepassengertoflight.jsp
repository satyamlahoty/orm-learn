<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form  action="removed?f_id=${flight.id}" method="post" > 
<input type="text"  name="id" value="${flight.id}"  id="id" disabled/>
<input type="text"  name="flightType" value="${flight.flightType} " id="flightType" disabled/>
<select name ="p">

<c:forEach var="p" items="${passengerList}">


 <option value="${p.id}">${p}</option>
</c:forEach>
</select>


<input type="submit" value="Remove Passneger"/>
</form>
</body>
</html>