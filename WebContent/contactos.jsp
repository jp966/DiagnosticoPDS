<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
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

<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand"><i class="fas fa-clipboard-list"></i> Gestión contactos</a>
  <button id="botonCierraSesion"  class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar sesión</button>
    
</nav>

<div class="container">
  <h2 style="margin-top:20px;margin-bottom:70px;"> Lista de contactos</h2>
  <div class="row">
  	
  		<button data-toggle="modal" data-target="#exampleModalCenter" type="button" class="btn btn-primary" style="margin-bottom:20px;margin-right:10px;">Añadir nuevo contacto <i class="fas fa-user-plus"></i>
  		</button>
  	
  		<button id="botonHabilitarBusqueda" type="button" class="btn" style="margin-bottom:20px;background-color:#00cc66;"><span  style="color:white;">Habilitar búsqueda <i class="fas fa-search"
></i></span>
 		</button>
 		
 		
 	
  </div>
  
  <form id="formBusquedaContacto" style="display:none;">
  
  <div class="form-check" style="margin-bottom:10px;">
		  <input class="form-check-input" type="checkbox" id="checkBusquedaAvanzada">
		  <label class="form-check-label" for="checkBusquedaAvanzada">
		    <span style="font-weight:bold;">Búsqueda avanzada</span>
		  </label>
  </div>
  
  <div class="form-row">
  
    <div class="form-group col-md-2">
      <label for="nombreContactoBuscar">Nombre</label>
      <input type="text" class="form-control" id="nombreContactoBuscar" placeholder="Nombre" required>
    </div>
    
    <div class="form-group col-md-2">
      <label for="apellidoContactoBuscar">Apellido</label>
      <input type="text" class="form-control" id="apellidoContactoBuscar" placeholder="Apellido" required>
    </div>
    
    <div class="form-group col-md-2">
	    <label for="runContactoBuscar">RUN</label>
	    <input type="text" maxlength="12" class="form-control" id="runContactoBuscar" placeholder="RUN" required>
	</div>
	
	<div class="form-group col-md-2">
	    <label for="mailContactoBuscar">Mail</label>
	    <input type="mail" class="form-control" id="mailContactoBuscar" placeholder="Mail" required>
	</div>
	
	<div class="form-group col-md-2">
      <label for="direccionContactoBuscar">Dirección</label>
      <input type="text" class="form-control" id="direccionContactoBuscar" placeholder="Dirección" required>
    </div>
    
    <div class="form-group col-md-2">
      <label for="residenciaContactoBuscar">Lugar residencia</label>
     <input type="text" class="form-control" id="residenciaContactoBuscar" placeholder="Lugar residencia" required>
      
    </div>
    
  </div>
  
  <div class="form-row">
  	 <div class="form-group col-md-2">
      <label for="fechaNacimientoContactoBuscar">Fecha nacimiento</label>
      <input type="text" class="form-control" id="fechaNacimientoContactoBuscar" placeholder="Fecha nacimiento" required>
    </div>
    
    <div class="form-group col-md-2">
      <label for="telefonoContactoBuscar">Teléfono</label>
     <input type="text" maxlength="20" class="form-control" id="telefonoContactoBuscar" placeholder="Teléfono" required>
      
    </div>
    
    <div class="form-group col-md-2">
      <label for="organizacionContactoBuscar">Organización</label>
      <input type="text" class="form-control" id="organizacionContactoBuscar" placeholder="Organización en la que trabaja" required>
    </div>
    
     <div class="form-group col-md-2">
	      <label for="fotoContactoBuscar">Foto</label>
	     <input type="text" class="form-control" id="fotoContactoBuscar" placeholder="Foto contacto (enlace)" required>
	      
	    </div>
	    
	  <div class="form-group col-md-2">
	  	<button id="boton-buscar" type="button" class="btn" style="height:50px;background-color:#00cc66;"><span  style="color:white;">Buscar <i class="fas fa-search"
></i></span></button>
	  </div>
	 
	 
  </div>
  
  </form>	
  
  
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
        <h5 class="modal-title" id="exampleModalLongTitle"><i class="fas fa-user-circle"></i> Nuevo contacto</h5>
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

<!-- Modal para ver detalle contacto -->

<div class="modal fade" id="modalDetalleContacto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">
       
        	<i class="fas fa-user"></i></i> Detalle del contacto

        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="cardDetalleContacto">
        
      </div>
      
    </div>
  </div>
</div>

<!-- Fin de modal para ver detalle contacto -->

<!-- Modal para editar contacto -->

<div class="modal fade" id="modalEditarContacto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">
       
        	<i class="fas fa-pencil-alt"></i> Editar contacto

        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="cardEditarContacto">
        
      </div>
      
    </div>
  </div>
</div>

<!-- Fin de modal para ver detalle contacto -->

<!-- Modal para editar contacto -->

<div class="modal fade" id="modalBitacoraContacto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">
       
        	<i class="fas fa-book"></i> Bitácora contacto

        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="cardBitacoraContacto">
        <%@include file="bitacoraContacto.jsp"%>
        
    </div>
  </div>
</div>
</div>

<!-- Fin de modal para ver detalle contacto -->

</body>
</html>