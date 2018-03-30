var retrievedObject = localStorage.getItem('estado');
if(JSON.parse(retrievedObject)){
	$(document).ready(function(){

		var idContacto="0";
		var esBusquedaActivada=false;
		var esBusquedaAvanzada=false;
		
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
		
		//Botón para cerrar sesión
		$("#botonCierraSesion").on("click",function(){
			localStorage.removeItem("estado");
			window.location.replace("index.jsp")
		});
		
		//Botón para habilitar las búsquedas
		$("#botonHabilitarBusqueda").on("click",function(){
			if($("#formBusquedaContacto").css("display")==="none"){
			  $("#botonHabilitarBusqueda").html("<span  style='color:white;'>Deshabilitar búsqueda <i class='fas fa-search'></i></span>");
			  $("#formBusquedaContacto").show();
			}else{
				$("#nombreContactoBuscar").val("");
				$("#apellidoContactoBuscar").val("");
				$("#runContactoBuscar").val("");
				$("#mailContactoBuscar").val("");
				$("#direccionContactoBuscar").val("");
				$("#telefonoContactoBuscar").val("");
				$("#fechaNacimientoContactoBuscar").val("");
				$("#residenciaContactoBuscar").val("");
				$("#organizacionContactoBuscar").val("");
				$("#fotoContactoBuscar").val("");
				$('#checkBusquedaAvanzada').prop('checked', false); // Unchecks it
				esBusquedaAvanzada=false;
				$("#botonHabilitarBusqueda").html("<span  style='color:white;'>Habilitar búsqueda <i class='fas fa-search'></i></span>");
				$("#formBusquedaContacto").hide();
			}
			
		});
		
		$("#boton-buscar").on("click",function(){
			var tipoBusqueda;
			if(esBusquedaAvanzada){
				tipoBusqueda="avanzada";
			}else{
				tipoBusqueda="simple";
			}
			$.ajax({
				type:"POST",
				url:"BuscaContacto",
				data: {
					nombre:$("#nombreContactoBuscar").val(),
					apellido:$("#apellidoContactoBuscar").val(),
					run:$("#runContactoBuscar").val(),
					mail:$("#mailContactoBuscar").val(),
					direccion:$("#direccionContactoBuscar").val(),
					telefono:$("#telefonoContactoBuscar").val(),
					fechaNacimiento:$("#fechaNacimientoContactoBuscar").val(),
					lugarResidencia:$("#residenciaContactoBuscar").val(),
					organizacion:$("#organizacionContactoBuscar").val(),
					foto:$("#fotoContactoBuscar").val(),
					tipoBusqueda:tipoBusqueda},
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
		});
		
		$("#checkBusquedaAvanzada").change(function(){
			esBusquedaAvanzada=!esBusquedaAvanzada;
		});
		
		
		//Botón ver bitácora contacto de la tabla
		$("body").on("click","#verBitacora",function(){
			idContacto = $(this).closest('td').siblings().find('#idContacto').html();
			
			
			$.ajax({
				type:"POST",
				url:"BitacoraContacto",
				data: {idContacto:idContacto,operacion:"obtenerAnotaciones"},
				beforeSend: function(){
					$("#listaAnotaciones").empty();
					$("#contenedor-cargando").show();
				},
				success: function(respuesta){
					$(respuesta).appendTo("#listaAnotaciones");
					
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
		
		//Botón bitácora contacto de modal
		$("body").on("click","#boton-anotacion",function(){
			//si el formulario de creacion de anotación es válido, entonces...
			if($("#tituloAnotacion").val()!="" && $("#contenidoAnotacion").val()!="" ){
				$.ajax({
					type:"POST",
					url:"BitacoraContacto",
					data: {idContacto:idContacto,
						titulo:$("#tituloAnotacion").val(),
						contenido:$("#contenidoAnotacion").val(),
						operacion:"crearAnotacion"},
					beforeSend: function(){
						//$("#listaAnotaciones").empty();
						//$("#contenedor-cargando").show();
					},
					success: function(respuesta){
						$("#tituloAnotacion").val("");
						$("#contenidoAnotacion").val("");
						

						$.ajax({
							type:"POST",
							url:"BitacoraContacto",
							data: {idContacto:idContacto,operacion:"obtenerAnotaciones"},
							beforeSend: function(){
								$("#listaAnotaciones").empty();
								$("#contenedor-cargando").show();
							},
							success: function(respuesta){
								$(respuesta).appendTo("#listaAnotaciones");
								
							},
							error: function(xhr, status, error) {
								  var err = eval("(" + xhr.responseText + ")");
								  alert(err.Message);
							},
							complete: function(){
								$("#contenedor-cargando").hide();
							}

						});
						
					},
					error: function(xhr, status, error) {
						  var err = eval("(" + xhr.responseText + ")");
						  alert(err.Message);
					},
					complete: function(){
						//$("#contenedor-cargando").hide();

					}

				});
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

					$("body").find("#fechaNacimientoContactoEditar").datepicker();
					
					$("body").find("#runContactoEditar").rut({
				    	formatOn: 'keyup',
				        minimumLength: 8, // validar largo mínimo; default: 2
				    	validateOn: 'change' // si no se quiere validar, pasar null
				    });
					  
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
		$("body").on("submit","#formEditarContacto",function(){
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
					//$("#modalEditarContacto").modal('toggle');
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
		
		//validador rut al editar
		$("body").on("change","#runContactoEditar",function() {

		    $.ajax({
				type:"POST",
				url:"ValidaRunContacto",
				data: {idContacto:idContacto,run:$(this).val(),operacion:"editar"},
				beforeSend: function(){
					
				},
				success: function(respuesta){
					if(respuesta==='true'){
						alert(respuesta);
						$("body").find("#runContactoEditar").get(0).setCustomValidity('El run ya está registrado');
						
					}else if(respuesta==='false'){
						$("body").find("#runContactoEditar").get(0).setCustomValidity('');
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
}else{
	window.location.replace("index.jsp");
}

