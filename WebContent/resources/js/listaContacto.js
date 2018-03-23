$(document).ready(function(){
	
	var idContacto="0";
	
	$.ajax({
		type:"POST",
		url:"ListaContacto",
		data: {},
		beforeSend: function(){
			$("#body-tabla").empty();
			$("#contenedor-cargando").show();
			
		},
		success: function(respuesta){
			$(respuesta).appendTo("#body-tabla");
			
		},
		error: function(xhr, status, error) {
			  var err = eval("(" + xhr.responseText + ")");
			  alert(err.Message);
		},
		complete: function(){
			$("#contenedor-cargando").hide();
		}



	});
	
	//Botón editar contacto
	$("body").on("click","#editar",function(){
		idContacto = $(this).closest('td').siblings().find('#idContacto').html();
		
		$.ajax({
			type:"POST",
			url:"EditaContacto",
			data: {idContacto:idContacto,operacion:"obtenerDatos"},
			beforeSend: function(){
				$("#cardEditarContacto").empty();
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				$(respuesta).appendTo("#cardEditarContacto");
				//alert(respuesta);
				
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
	
	//Botón editar contacto del modal
	$("body").on("click","#boton-editar",function(){
		$.ajax({
			type:"POST",
			url:"EditaContacto",
			data: {
				idContacto:idContacto,
				nombre:$("#nombreContactoEditar").val(),
				apellido:$("#apellidoContactoEditar").val(),
				run:$("#runContactoEditar").val(),
				mail:$("#mailContactoEditar").val(),
				direccion:$("#direccionContactoEditar").val(),
				telefono:$("#telefonoContactoEditar").val(),
				fechaNacimiento:$("#fechaNacimientoContactoEditar").val(),
				lugarResidencia:$("#residenciaContactoEditar").val(),
				organizacion:$("#organizacionContactoEditar").val(),
				foto:$("#fotoContactoEditar").val(),
				operacion:"guardarCambios"},
			beforeSend: function(){
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				$("#modalEditarContacto").modal('toggle');
				location.reload();
				
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
	
	//Botón ver detalle contacto de la tabla
	$("body").on("click","#verDetalle",function(){
		idContacto = $(this).closest('td').siblings().find('#idContacto').html();
		
		$.ajax({
			type:"POST",
			url:"DetalleContacto",
			data: {idContacto:idContacto},
			beforeSend: function(){
				$("#cardDetalleContacto").empty();
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				$(respuesta).appendTo("#cardDetalleContacto");
				
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
	
	
	
	
	
	
	//Botón eliminar del modal de confirmación
	$("body").on("click","#boton-eliminar",function(){
		$.ajax({
			type:"POST",
			url:"EliminaContacto",
			data: {idContacto:idContacto},
			beforeSend: function(){
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				$("#modalEliminarContacto").modal('toggle');
				location.reload();
				
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
	//Botón eliminar de la tabla
	$("body").on("click", "#eliminar", function(){
		idContacto = $(this).closest('td').siblings().find('#idContacto').html();
	});
		


});