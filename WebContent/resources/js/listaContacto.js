$(document).ready(function(){
	
	var idContacto="0";
	
	$.ajax({
		type:"POST",
		url:"ListaContacto",
		data: {},
		beforeSend: function(){
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
	//Botón eliminar del modal de confirmación
	$("#formEliminarContacto").submit(function(){
		
		
		$.ajax({
			type:"POST",
			url:"EliminaContacto",
			data: {idContacto:idContacto},
			beforeSend: function(){
				$("#contenedor-cargando").show();
			},
			success: function(respuesta){
				
				
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