<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="model.Libro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Libros de la Temática:${requestScope.descripciontema} </h1>

<%--<c:set var="listalibros" value="${requestScope.librostema}"/>--%>
<%--items="${listalibros} --%>

<table border ="1">
   <tr>
   <th>ISBN  </th> 
   <th>Título</th> 
   <th>Autor </th> 
   <th>Precio</th>
   <th>Páginas</th>
   <th>       </th>
   </tr>
   <br>
    
  
   <c:forEach var="libro" items="${requestScope.librostema}">
      <tr>
      <td>${libro.isbn}</td>
      <td>${libro.titulo}</td>
      <td>${libro.autor}</td>
      <td>${libro.precio}</td>
      <td>${libro.paginas}</td>
      <td><a href="Controller?idTema=${param.idTema}&option=doAgregarCarro&isbn=${libro.isbn}">Comprar</a></td>
      </tr>	 
   </c:forEach> 
</table>
</center>
<br>


 <%-- Carrito --%>
 <center>
 <h1>Carrito</h1>
<c:if test="${!empty sessionScope.libroscarrito}">
   <table border="1">
   <tr>
     <th>ISBN  </th> 
     <th>Título</th> 
     <th>Autor </th> 
     <th>Precio</th>
     <th>Páginas</th>
     <th>       </th>
   </tr>
   <br>

   <c:forEach var="carrito" items="${sessionScope.libroscarrito}" varStatus="i">
       <tr>
		 <td>${carrito.isbn}</td>
         <td>${carrito.titulo}</td>
         <td>${carrito.autor}</td>
         <td>${carrito.precio}</td>
         <td>${carrito.paginas}</td>
         <td><a href="Controller?idTema=${param.idTema}&option=doEliminarCarro&posicion=${i.index}">Eliminar</a></td>	
       </tr>		    	
</c:forEach>
    </table>
</c:if>
</center>

<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>