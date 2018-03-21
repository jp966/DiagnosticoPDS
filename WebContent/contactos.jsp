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
<script src="resources/js/listaContacto.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de registro</title>
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
   		<div id="contenedor-cargando" style="display:none;">
   			<center>
   			<img src="resources/gif/ajax-loader.gif" width="100" height="100">
   			</center>
   		</div>

      
    </tbody>
  </table>
</div>

</body>
</html>