$(document).ready(function(){
	
	$( "#formNuevoContacto" ).submit(function( event ) {
		alert("enviado")
		$.ajax({
			type:"POST",
			url:"AgregaContacto",
			data: {
				nombre:$("#nombreContacto").val(),
				apellido:$("#apellidoContacto").val(),
				run:$("#runContacto").val(),
				mail:$("#mailContacto").val(),
				direccion:$("#direccionContacto").val(),
				telefono:$("#telefonoContacto").val(),
				fechaNacimiento:$("#fechaNacimientoContacto").val(),
				lugarResidencia:$("#residenciaContacto").val(),
				organizacion:$("#organizacionContacto").val(),
				foto:$("#fotoContacto").val()
				
			},
			beforeSend: function(){
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				//cerrar modal
				
			},
			error: function(xhr, status, error) {
				  var err = eval("(" + xhr.responseText + ")");
				  alert(err.Message);
			},
			complete: function(){
				$("#contenedor-cargando").hide();
			}



		});
	});
	
	
	
		
		
		
		


});