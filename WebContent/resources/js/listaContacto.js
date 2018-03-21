$(document).ready(function(){

	
		$.ajax({
			type:"POST",
			url:"ListaContacto",
			data: {},
			success: function(respuesta){
				/*
				console.log(respuesta)
				var tableBody = document.getElementById("body-tabla");
				
				 for (i = 0; i < respuesta.length; i++) {
				        var tr = document.createElement('TR');
				     
				        var td = document.createElement('TD')
				        td.appendChild(document.createTextNode(respuesta[i].nombre));
				        tr.appendChild(td)
				        
				        var td = document.createElement('TD')
				        td.appendChild(document.createTextNode(respuesta[i].apellido));
				        tr.appendChild(td)
				        
				        var td = document.createElement('TD')
				        td.appendChild(document.createTextNode(respuesta[i].run));
				        tr.appendChild(td)
				        
				        var td = document.createElement('TD')
				        td.appendChild(document.createTextNode(respuesta[i].telfono));
				        tr.appendChild(td)
				        
				        var td = document.createElement('TD')
				        td.appendChild(document.createTextNode(respuesta[i].mail));
				        tr.appendChild(td)
				       
				        tableBody.appendChild(tr);
				 }  */
				
			},
			error: function(xhr, status, error) {
				  var err = eval("(" + xhr.responseText + ")");
				  alert(err.Message);
				}



		});
		
		
		
		


});