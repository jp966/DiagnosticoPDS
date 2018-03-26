<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/agregarContacto.js"></script>
<script src="resources/js/jquery.rut.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<form id="formNuevoContacto">
  <div class="form-row">
  
    <div class="form-group col-md-6">
      <label for="nombreContacto">Nombre</label>
      <input type="text" class="form-control" id="nombreContacto" placeholder="Nombre" required>
    </div>
    <div class="form-group col-md-6">
      <label for="apellidoContacto">Apellido</label>
      <input type="text" class="form-control" id="apellidoContacto" placeholder="Apellido" required>
    </div>
    
  </div>
  
  
  <div class="form-row">
  
	  <div class="form-group col-md-6">
	    <label for="runContacto">RUN</label>
	    <input type="text" maxlength="12" class="form-control" id="runContacto" placeholder="RUN" required>
	  </div>
	  <div class="form-group col-md-6">
	    <label for="mailContacto">mail</label>
	    <input type="mail" class="form-control" id="mailContacto" placeholder="Mail" required>
	  </div>
  
  </div>
  
  
  <div class="form-row">
  
    <div class="form-group col-md-12">
      <label for="direccionContacto">Dirección</label>
      <input type="text" class="form-control" id="direccionContacto" placeholder="Dirección" required>
    </div>
    
   
  </div>
  
   <div class="form-row">
  
    <div class="form-group col-md-12">
      <label for="residenciaContacto">Lugar residencia</label>
     <input type="text" class="form-control" id="residenciaContacto" placeholder="Lugar residencia" required>
      
    </div>
   
  </div>
  
  <div class="form-row">
  
    <div class="form-group col-md-6">
      <label for="fechaNacimientoContacto">Fecha nacimiento</label>
      <input type="text" class="form-control" id="fechaNacimientoContacto" placeholder="Fecha nacimiento" required>
    </div>
    
    <div class="form-group col-md-6">
      <label for="telefonoContacto">Teléfono</label>
     <input type="text" maxlength="20" class="form-control" id="telefonoContacto" placeholder="Teléfono" required>
      
    </div>
    
   
  </div>
  
  <div class="form-row">
  
    <div class="form-group col-md-12">
      <label for="organizacionContacto">Organización</label>
      <input type="text" class="form-control" id="organizacionContacto" placeholder="Organización en la que trabaja" required>
    </div>
    
   
  </div>
  
  <div class="form-row">
	  <div class="form-group col-md-12">
	      <label for="fotoContacto">Foto</label>
	     <input type="text" class="form-control" id="fotoContacto" placeholder="Foto contacto (enlace)" required>
	      
	    </div>
  </div>
  
  <!-- <button type="submit" class="btn btn-primary">Sign in</button>-->
  
  <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button id="boton-agregar" type="submit" class="btn btn-primary">Añadir nuevo contacto <i class="far fa-plus-square"></i></button>
  </div>
  
</form>
</body>
</html>