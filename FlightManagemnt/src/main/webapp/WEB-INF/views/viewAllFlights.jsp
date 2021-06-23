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
<table border="1">
<tr> 
<th>
Flight ID 
</th>
<th>
Flight name
</th>
<c:forEach var="f" items="${flightList}">
<tr>
<td>${f.id}</td>
<td>${f.flightType}</td>
<td><a href="delstudent?sid=${f.id}">Delete</a></td>
<td><a href="updatestudent?id=${f.id}&flightType=${f.flightType}">Update</a></td> 
<td><a href="addpassengertoflight?id=${f.id}">Add Passenger</a></td>
<td><a href="removepassengertoflight?id=${f.id}">Remove Passenger</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>

