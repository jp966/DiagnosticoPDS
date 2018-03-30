var retrievedObject = localStorage.getItem('estado');
if(JSON.parse(retrievedObject)){
	window.location.replace("contactos.jsp");
}else{
	$(document).ready(function(){

		$( "#submit" ).click(function(event) {
			
			$.ajax({
				type:"POST",
				url:"IngresoSistema",
				data: {nombreUsuario:$("#nombreUsuario").val(),password:$("#password").val()},
				beforeSend: function(){
					$("#contenedor-cargando").css("display", "inline-block");
					$("#contenedor-mensaje").empty();
				},
				success: function(respuesta){
					
					if(respuesta==="true"){
						var estadoJson = { 'estado': 1};
						localStorage.setItem("estado", JSON.stringify(estadoJson));
						$(location).attr('href','contactos.jsp');
					}else if(respuesta==="false"){
						$("#contenedor-mensaje").append("<span style='color:red'>Usuario o contraseña incorrectas</span>")
						//alert("El usuario o contraseña no son válidas")
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

}
