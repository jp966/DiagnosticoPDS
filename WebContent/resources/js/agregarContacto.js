$(document).ready(function(){
	
	$( function() {
	    $( "#fechaNacimientoContacto" ).datepicker();
	    $("#runContacto").rut({
	    	formatOn: 'keyup',
	        minimumLength: 8, // validar largo mínimo; default: 2
	    	validateOn: 'change' // si no se quiere validar, pasar null
	    });
	  } );
	
	$("body").on("change","#runContacto",function() {

	    $.ajax({
			type:"POST",
			url:"ValidaRunContacto",
			data: {run:$(this).val(),operacion:"crear"},
			beforeSend: function(){
				
			},
			success: function(respuesta){
				if(respuesta==='true'){
					alert(respuesta);
					$("body").find("#runContacto").get(0).setCustomValidity('El run ya está registrado');
					
				}else if(respuesta=="false"){
					$("body").find("#runContacto").get(0).setCustomValidity('');
				} 
				//alert(respuesta);
				
			},
			error: function(xhr, status, error) {
				  var err = eval("(" + xhr.responseText + ")");
				  alert(err.Message);
			},
			complete: function(){
				
			}

		});

	  });
	  
	
	$("body").on("submit","#formNuevoContacto",function( ) {
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
				//$("#exampleModalCenter").modal('toggle');
				//location.reload();
				
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