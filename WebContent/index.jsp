<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/ingresoSistema.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="row">
	<div style="margin-top:100px;" class="col 12">
		<center>
			<h2>Login</h2>
	<div style="width:50%;">
	 
	        <form id="formLogin" method="post">
		        <div class="form-group">
		            <label for="nombreUsuario">Usuario</label>
		            <input type="text" name="nombreUsuario" id="nombreUsuario" class="form-control" required />
		        </div>
		        <div class="form-group">
		            <label for="password">Password</label>
		            <input type="password" name="password" id="password" class="form-control" required />
		        </div>
		        <div class="form-actions">
		        	<button type="button" id="submit" class="btn btn-primary">Iniciar sesión</button>
		        	<div id="contenedor-cargando" style="display:none;">
		        	<img src="resources/gif/ajax-loader.gif">
		        	</div>
		        </div>
		    </form>
		</div>
		</center>
	</div>	
    
</div>


	 
</body>
</html>