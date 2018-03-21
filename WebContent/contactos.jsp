<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="sistema.Contacto"%>
    <%@page import="sistema.ContactoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/fontawesome/css/fontawesome-all.css">
<link rel="stylesheet" href="resources/fontawesome/css/fontawesome-all.min.css">
<link rel="stylesheet" href="resources/fontawesome/css/fontawesome.css">
<link rel="stylesheet" href="resources/fontawesome/css/fontawesome.min.css">
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <h2 style="margin-top:20px;margin-bottom:70px;"> Lista de contactos</h2>
  <button type="button" class="btn btn-primary" style="margin-bottom:20px;">Añadir nuevo contacto <i class="fas fa-user-plus"></i>

  </button>
  
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Apelido</th>
        <th>RUN</th>
        <th>Teléfono</th>
        <th>Mail</th>
        <th>Acciones</th>	
      </tr>
    </thead>
    <tbody id="body-tabla">
    <% 
    Contacto[] arrayContactos = ContactoDAO.listContactoByQuery(null,null);
    //Contacto[] contactos = (Contacto[])request.getSession().getAttribute("contactos");
    //out.print(contactos.get(0).getNombre());
    for(Contacto contacto : arrayContactos)
    {
       out.print("<tr>");
       
	       out.print("<td>");
	       	out.print(contacto.getNombre());
	       out.print("</td>");
	       
	       out.print("<td>");
	       	out.print(contacto.getApellido());
	       out.print("</td>");
       
	       out.print("<td>");
	       	out.print(contacto.getRun());
	       out.print("</td>");
	       
	       out.print("<td>");
	       	out.print(contacto.getTelefono());
	       out.print("</td>");
	       
	       out.print("<td>");
	       	out.print(contacto.getMail());
	       out.print("</td>");

	       %>
	       <td>
	       <button type="button" class="btn" style="background-color: #ff8533"><i class="far fa-address-book" style="color:white;"></i></button>
	       <button type="button" class="btn" style="background-color:#009999;"><i class="far fa-edit" style="color:white;"></i></button>
	       <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
	       </td>
	       <%
	       
       out.print("</tr>");
    }
%>
      
    </tbody>
  </table>
</div>

</body>
</html>