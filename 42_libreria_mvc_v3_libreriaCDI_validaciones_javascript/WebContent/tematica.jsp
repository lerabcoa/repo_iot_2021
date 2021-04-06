<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"      import="model.Tema" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<body>

<center>
<label for="idTema">Temáticas</label> 


<form action="Controller?option=doLibros" method="POST">
      <select name="idTema"> 
              <option value="0">-Todos-</option>
              <c:forEach var="t" items="${requestScope.temas}">
                 <option value="${t.id_tema}"> ${t.descripcion}</option>
              </c:forEach>
      </select>
      <br>
      <br>
      <input type="submit" value="Libros"/>
 </form>
</center>
</body>
</html>
