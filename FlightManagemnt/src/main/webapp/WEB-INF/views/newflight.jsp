<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form  action="addflight" modelAttribute="flight" method="post">
      <table>
          <tr>
              <td>Id:</td>
              <td><form:input path="id" /></td>
          </tr>
          <tr>
              <td>Flight Type:</td>
              <td><form:select path="flightType" items="${type}" /></td>
              
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Create" />
              </td>
          </tr>
      </table>
  </form:form>
</body>
</html>