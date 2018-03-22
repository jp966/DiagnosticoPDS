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
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.js"></script>

<script src="resources/js/listaContacto.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de registro</title>
</head>
<body>

<div class="container">
  <h2 style="margin-top:20px;margin-bottom:70px;"> Lista de contactos</h2>
  <button data-toggle="modal" data-target="#exampleModalCenter" type="button" class="btn btn-primary" style="margin-bottom:20px;">Añadir nuevo contacto <i class="fas fa-user-plus"></i>

  </button>
  <table class="table table-striped">
    <thead>
      <tr>
      	<th style="display:none;">ID</th> 
        <th>Nombre</th>
        <th>Apelido</th>
        <th>RUN</th>
        <th>Teléfono</th>
        <th>Mail</th>
        <th>Acciones</th>	
      </tr>
    </thead>
    <tbody id="body-tabla">
   		

      
    </tbody>
    
  </table>
  
  <div id="contenedor-cargando" style="display:none;">
   			<center>
   			<img src="resources/gif/ajax-loader.gif" width="100" height="100">
   			</center>
   		</div>
</div>

<!-- Modal para creación de contacto -->

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Nuevo contacto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	
       <%@include file="agregarContacto.jsp"%>
       	
      </div>
      
    </div>
  </div>
</div>

<!-- Fin modal para creación de contacto -->

<!-- Modal para eliminar un contacto -->

<div class="modal fade" id="modalEliminarContacto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><i class="fas fa-exclamation-circle"></i> Confirmar acción

        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <%@include file="eliminarContacto.jsp"%>
      </div>
      
    </div>
  </div>
</div>

<!-- Fin de modal para eliminar un contacto -->

</body>
</html>