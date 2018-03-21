$(document).ready(function(){

	
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
		
		
		
		


});