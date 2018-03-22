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

	$("#boton-eliminar").click(function(){
		alert(idContacto)
		$.ajax({
			type:"POST",
			url:"EliminaContacto",
			data: {id:idContacto},
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
	
	$("#eliminarTest").click(function(){
		alert("hola");
		alert($(this).name);
		//idContacto = $('#eliminar').closest('td').siblings().find('#idContacto').html();
		//alert(idContacto);
	});
	
	
	
		
		
		
		


});