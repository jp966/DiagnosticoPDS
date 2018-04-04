<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
        	<div class="col-md-6">
        		<form id="formBitacoraContacto">
        		<% Date fechaActual = new Date();
        		String fechaFormat = fechaActual.getDate() +" / "+(fechaActual.getMonth()+1)+" / "+(fechaActual.getYear()+1900);
        		pageContext.setAttribute("fecha", fechaFormat );%>
        			<span><span style="font-weight:bold;">Fecha: </span>${fecha}</span>
        			<div class="form-row">
  
					    <div class="form-group col-md-12">
					      <label for="tituloAnotacion">Título: </label>
					      <input type="text" maxlength="255" class="form-control" id="tituloAnotacion" placeholder="Título" required>
					    </div>
					    
					   
					  </div>
					  <div class="form-row">
					  
					    <div class="form-group col-md-12">
					      <label for="contenidoAnotacion">Contenido: </label>
					      <textarea rows="6" maxlength="255" type="text" class="form-control" id="contenidoAnotacion" placeholder="Contenido anotación" required></textarea>
					      <span>(255 caracteres máximo)</span>
					    </div>
					    
					   
					  </div>
					  <div>
					  		 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
					        <button id="boton-anotacion" type="button" class="btn btn-primary">Añadir nueva anotación</button>
					  </div>
        		</form>
        	</div>
        	<div id="listaAnotaciones" class="col-md-6" style="overflow-y: scroll; height:470px;">
        		
				
        	</div>
        </div>
      </div>
      
</body>
</html>