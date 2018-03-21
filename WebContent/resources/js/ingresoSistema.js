
$(document).ready(function(){

	$( "#submit" ).click(function(event) {
		
		$.ajax({
			type:"POST",
			url:"IngresoSistema",
			data: {nombreUsuario:$("#nombreUsuario").val(),password:$("#password").val()},
			beforeSend: function(){
				$("#contenedor-cargando").css("display", "inline-block");
			},
			success: function(respuesta){
				
				if(respuesta==="true"){
					$(location).attr('href','contactos.jsp');
				}else if(respuesta==="false"){
					alert("El usuario o contraseña no son válidas")
				}
				
				
			},
			error: function(xhr,textStatus,err)
			{
			    alert("readyState: " + xhr.readyState);
			    alert("responseText: "+ xhr.responseText);
			    alert("status: " + xhr.status);
			    alert("text status: " + textStatus);
			    alert("error: " + err);
			},
			complete: function(){
				$("#contenedor-cargando").hide();
			}



		});
		/*
		
		$.post("IngresoSistema",{
			nombreUsuario:$("#nombreUsuario").val(),password:$("#password").val()
			
		  },function(respuesta){
			  alert(respuesta)
			  if(respuesta.esValido){
					$(location).attr('href','contactos.jsp');
				}else if(!respuesta.esValido){
					alert("El usuario o contraseña no son válidas")
				}
		  });
		
		
		*/
		
	});

});
