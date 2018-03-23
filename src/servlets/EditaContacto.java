package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import sistema.ContactoDAO;
import sistema.Contacto;

/**
 * Servlet implementation class EditaContacto
 */
@WebServlet("/EditaContacto")
public class EditaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditaContacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idContacto = request.getParameter("idContacto");
		String operacion = request.getParameter("operacion");
		
		//Si la operación que se realiza es la de obtener datos para llenar inputs...
		if(operacion.equals("obtenerDatos")) {
			response.setContentType("text/plain");

			PrintWriter out = response.getWriter();
			
			try {
				Contacto contacto = ContactoDAO.loadContactoByORMID(Integer.parseInt(idContacto));
				ContactoDAO.refresh(contacto);
				out.println("<form id=\"formEditarContacto\">\n" + 
						"  <div class=\"form-row\">\n" + 
						"  \n" + 
						"    <div class=\"form-group col-md-6\">\n" + 
						"      <label for=\"nombreContacto\">Nombre</label>\n" + 
						"      <input type=\"text\" class=\"form-control\" id=\"nombreContactoEditar\" placeholder=\"Nombre\" value='"+contacto.getNombre()+"' required>\n" + 
						"    </div>\n" + 
						"    <div class=\"form-group col-md-6\">\n" + 
						"      <label for=\"apellidoContacto\">Apellido</label>\n" + 
						"      <input type=\"text\" class=\"form-control\" id=\"apellidoContactoEditar\" placeholder=\"Apellido\" value='"+contacto.getApellido()+"' required>\n" + 
						"    </div>\n" + 
						"    \n" + 
						"  </div>\n" + 
						"  \n" + 
						"  \n" + 
						"  <div class=\"form-row\">\n" + 
						"  \n" + 
						"	  <div class=\"form-group col-md-6\">\n" + 
						"	    <label for=\"runContacto\">RUN</label>\n" + 
						"	    <input type=\"text\" maxlength=\"12\" class=\"form-control\" id=\"runContactoEditar\" placeholder=\"RUN\" value='"+contacto.getRun()+"' required>\n" + 
						"	  </div>\n" + 
						"	  <div class=\"form-group col-md-6\">\n" + 
						"	    <label for=\"mailContacto\">Mail</label>\n" + 
						"	    <input type=\"mail\" class=\"form-control\" id=\"mailContactoEditar\" placeholder=\"Mail\" value='"+contacto.getMail()+"' required>\n" + 
						"	  </div>\n" + 
						"  \n" + 
						"  </div>\n" + 
						"  \n" + 
						"  \n" + 
						"  <div class=\"form-row\">\n" + 
						"  \n" + 
						"    <div class=\"form-group col-md-12\">\n" + 
						"      <label for=\"direccionContacto\">Dirección</label>\n" + 
						"      <input type=\"text\" class=\"form-control\" id=\"direccionContactoEditar\" placeholder=\"Dirección\" value='"+contacto.getDireccion()+"' required>\n" + 
						"    </div>\n" + 
						"    \n" + 
						"   \n" + 
						"  </div>\n" + 
						"  \n" + 
						"   <div class=\"form-row\">\n" + 
						"  \n" + 
						"    <div class=\"form-group col-md-12\">\n" + 
						"      <label for=\"residenciaContacto\">Lugar residencia</label>\n" + 
						"     <input type=\"text\" class=\"form-control\" id=\"residenciaContactoEditar\" placeholder=\"Lugar residencia\" value='"+contacto.getLugarResidencia()+"' required>\n" + 
						"      \n" + 
						"    </div>\n" + 
						"   \n" + 
						"  </div>\n" + 
						"  \n" + 
						"  <div class=\"form-row\">\n" + 
						"  \n" + 
						"    <div class=\"form-group col-md-6\">\n" + 
						"      <label for=\"fechaNacimientoContacto\">Fecha nacimiento</label>\n" + 
						"      <input type=\"text\" class=\"form-control\" id=\"fechaNacimientoContactoEditar\" placeholder=\"Fecha nacimiento\" value='"+contacto.getFechaNacimiento()+"' required>\n" + 
						"    </div>\n" + 
						"    \n" + 
						"    <div class=\"form-group col-md-6\">\n" + 
						"      <label for=\"telefonoContacto\">Teléfono</label>\n" + 
						"     <input type=\"text\" maxlength=\"20\" class=\"form-control\" id=\"telefonoContactoEditar\" placeholder=\"Teléfono\" value='"+contacto.getTelefono()+"' required>\n" + 
						"      \n" + 
						"    </div>\n" + 
						"    \n" + 
						"   \n" + 
						"  </div>\n" + 
						"  \n" + 
						"  <div class=\"form-row\">\n" + 
						"  \n" + 
						"    <div class=\"form-group col-md-12\">\n" + 
						"      <label for=\"organizacionContacto\">Organización</label>\n" + 
						"      <input type=\"text\" class=\"form-control\" id=\"organizacionContactoEditar\" placeholder=\"Organización en la que trabaja\" value='"+contacto.getOrganizacion()+"' required>\n" + 
						"    </div>\n" + 
						"    \n" + 
						"   \n" + 
						"  </div>\n" + 
						"  \n" + 
						"  <div class=\"form-row\">\n" + 
						"	  <div class=\"form-group col-md-12\">\n" + 
						"	      <label for=\"fotoContacto\">Foto</label>\n" + 
						"	     <input type=\"text\" class=\"form-control\" id=\"fotoContactoEditar\" placeholder=\"Foto contacto (enlace)\" value='"+contacto.getFoto()+"' required>\n" + 
						"	      \n" + 
						"	    </div>\n" + 
						"  </div>\n" + 
						"  \n" + 
						"  <!-- <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>-->\n" + 
						"  \n" + 
						"  <div class=\"modal-footer\">\n" + 
						"        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cerrar</button>\n" + 
						"        <button id='boton-editar' type=\"button\" class=\"btn btn-primary\">Guardar cambios <i class=\"far fa-save\"></i></button>\n" + 
						"  </div>\n" + 
						"  \n" + 
						"</form>");
				
				
				
			} catch (NumberFormatException | PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//Si la operación que se realiza es el guardado de cambios al editar...
		}else if(operacion.equals("guardarCambios")) {
			try {
				Contacto contacto = ContactoDAO.loadContactoByORMID(Integer.parseInt(idContacto));
				
				Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNacimiento"));
				contacto.setNombre(request.getParameter("nombre"));
				contacto.setApellido(request.getParameter("apellido"));
				contacto.setRun(request.getParameter("run"));
				contacto.setMail(request.getParameter("mail"));
				contacto.setDireccion(request.getParameter("direccion"));
				contacto.setTelefono(request.getParameter("telefono"));
				contacto.setFechaNacimiento(fecha);
				contacto.setLugarResidencia(request.getParameter("lugarResidencia"));
				contacto.setOrganizacion(request.getParameter("organizacion"));
				contacto.setFoto(request.getParameter("foto"));
				
				ContactoDAO.save(contacto);
				
				ContactoDAO.refresh(contacto);
				
			} catch (NumberFormatException | PersistentException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		
	}

}
