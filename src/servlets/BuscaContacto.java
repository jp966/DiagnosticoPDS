package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import sistema.Contacto;
import sistema.ContactoDAO;
/**
 * Servlet implementation class BuscaContacto
 */
@WebServlet("/BuscaContacto")
public class BuscaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaContacto() {
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
	 * Genera el código de la tabla de contactos de acuerdo a la búsqueda avanzada o simple
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String run = request.getParameter("run");
		String mail = request.getParameter("mail");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String lugarResidencia = request.getParameter("lugarResidencia");
		String organizacion = request.getParameter("organizacion");
		String foto = request.getParameter("foto");
		
		String tipoBusqueda = request.getParameter("tipoBusqueda");
		
		if(nombre.equals("") && tipoBusqueda.equals("simple")) {
			nombre="''";
		}else if(nombre.equals("") && tipoBusqueda.equals("avanzada")) {
			nombre="'%'";
		}else {
			nombre="'%"+nombre+"%'";
		}
		
		if(apellido.equals("") && tipoBusqueda.equals("simple")) {
			apellido="''";
		}else if(apellido.equals("") && tipoBusqueda.equals("avanzada")) {
			apellido="'%'";
		}else {
			apellido="'%"+apellido+"%'";
		}
			
		if(run.equals("") && tipoBusqueda.equals("simple")) {
			run="''";
		}else if(run.equals("") && tipoBusqueda.equals("avanzada")) {
			run="'%'";
		}else {
			run="'"+run+"%'";
		}
			
		if(mail.equals("") && tipoBusqueda.equals("simple")) {
			mail="''";
		}else if(mail.equals("") && tipoBusqueda.equals("avanzada")) {
			mail="'%'";
		}else {
			mail="'%"+mail+"%'";
		}
			
		if(direccion.equals("") && tipoBusqueda.equals("simple")) {
			direccion="''";
		}else if(direccion.equals("") && tipoBusqueda.equals("avanzada")) {
			direccion="'%'";
		}else {
			direccion="'%"+direccion+"%'";
		}
			
		if(telefono.equals("") && tipoBusqueda.equals("simple")) {
			telefono="''";
		}else if(telefono.equals("") && tipoBusqueda.equals("avanzada")) {
			telefono="'%'";
		}else {
			telefono="'%"+telefono+"%'";
		}
			
		if(fechaNacimiento.equals("") && tipoBusqueda.equals("simple")) {
			fechaNacimiento="''";
		}else if(fechaNacimiento.equals("") && tipoBusqueda.equals("avanzada")) {
			fechaNacimiento="'%'";
		}else {
			fechaNacimiento="'%"+fechaNacimiento+"%'";
		}
			
		if(lugarResidencia.equals("") && tipoBusqueda.equals("simple")) {
			lugarResidencia="''";
		}else if(lugarResidencia.equals("") && tipoBusqueda.equals("avanzada")) {
			lugarResidencia="'%'";
		}else {
			lugarResidencia="'%"+lugarResidencia+"%'";
		}
			
		if(organizacion.equals("") && tipoBusqueda.equals("simple")) {
			organizacion="''";
		}else if(organizacion.equals("") && tipoBusqueda.equals("avanzada")) {
			organizacion="'%'";
		}else {
			organizacion="'%"+organizacion+"%'";
		}
			
		if(foto.equals("") && tipoBusqueda.equals("simple")) {
			foto="''";
		}else if(foto.equals("") && tipoBusqueda.equals("avanzada")) {
			foto="'%'";
		}else {
			foto="'%"+foto+"%'";
		}
		
		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();
		
		if(tipoBusqueda.equals("avanzada")) {
			String query="nombre like "+nombre+" and apellido like "+apellido+" and run like "+run+" and mail like "+mail+" and direccion like "+direccion+" and telefono like "+telefono+" and fechaNacimiento like "+fechaNacimiento+" and lugarResidencia like "+lugarResidencia+" and organizacion like "+organizacion+" and foto like "+foto;
			try {
				Contacto[] arrayContactos = ContactoDAO.listContactoByQuery(query, null);

				for (int i = 0; i < arrayContactos.length; i++) {
					ContactoDAO.refresh(arrayContactos[i]);
					out.println("<tr>");
					
						out.println("<td style='display:none;'><span id='idContacto'>" + arrayContactos[i].getORMID() + "</span></td>");
						out.println("<td>" + arrayContactos[i].getNombre() + "</td>");
						out.println("<td>" + arrayContactos[i].getApellido() + "</td>");
						out.println("<td>" + arrayContactos[i].getRun() + "</td>");
						out.println("<td>" + arrayContactos[i].getTelefono() + "</td>");
						out.println("<td>" + arrayContactos[i].getMail() + "</td>");
						out.println("<td>");
							out.println("<button id='verDetalle' title='Ver detalle' data-toggle=\"modal\" data-target=\"#modalDetalleContacto\" type=\"button\" class=\"btn\" style=\"background-color:#00cc44;\"><i class=\"fas fa-eye\" style='color:white;'></i></button>");
							out.println("<button id='verBitacora' title='Bitácora' data-toggle=\"modal\" data-target=\"#modalBitacoraContacto\" type=\"button\" class=\"btn\" style=\"background-color: #ff8533\"><i class=\"far fa-address-book\" style=\"color:white;\"></i></button>");
							out.println("<button id='editar' title='Editar' data-toggle=\"modal\" data-target=\"#modalEditarContacto\" type=\"button\" class=\"btn\" style=\"background-color:#009999;\"><i class=\"far fa-edit\" style=\"color:white;\"></i></button>");
							out.println("<button id='eliminar' title='Eliminar' data-toggle=\"modal\" data-target=\"#modalEliminarContacto\" type=\"button\" class=\"btn btn-danger\"><i class=\"far fa-trash-alt\"></i></button>");
						out.println("</td>");
							
					out.println("</tr>");
				}
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(tipoBusqueda.equals("simple")) {
			String query="nombre like "+nombre+" or apellido like "+apellido+" or run like "+run+" or mail like "+mail+" or direccion like "+direccion+" or telefono like "+telefono+" or fechaNacimiento like "+fechaNacimiento+" or lugarResidencia like "+lugarResidencia+" or organizacion like "+organizacion+" or foto like "+foto;
			System.out.println(query);
			try {
				Contacto[] arrayContactos = ContactoDAO.listContactoByQuery(query, null);

				for (int i = 0; i < arrayContactos.length; i++) {
					ContactoDAO.refresh(arrayContactos[i]);
					out.println("<tr>");
					
						out.println("<td style='display:none;'><span id='idContacto'>" + arrayContactos[i].getORMID() + "</span></td>");
						out.println("<td>" + arrayContactos[i].getNombre() + "</td>");
						out.println("<td>" + arrayContactos[i].getApellido() + "</td>");
						out.println("<td>" + arrayContactos[i].getRun() + "</td>");
						out.println("<td>" + arrayContactos[i].getTelefono() + "</td>");
						out.println("<td>" + arrayContactos[i].getMail() + "</td>");
						out.println("<td>");
							out.println("<button id='verDetalle' title='Ver detalle' data-toggle=\"modal\" data-target=\"#modalDetalleContacto\" type=\"button\" class=\"btn\" style=\"background-color:#00cc44;\"><i class=\"fas fa-eye\" style='color:white;'></i></button>");
							out.println("<button id='verBitacora' title='Bitácora' data-toggle=\"modal\" data-target=\"#modalBitacoraContacto\" type=\"button\" class=\"btn\" style=\"background-color: #ff8533\"><i class=\"far fa-address-book\" style=\"color:white;\"></i></button>");
							out.println("<button id='editar' title='Editar' data-toggle=\"modal\" data-target=\"#modalEditarContacto\" type=\"button\" class=\"btn\" style=\"background-color:#009999;\"><i class=\"far fa-edit\" style=\"color:white;\"></i></button>");
							out.println("<button id='eliminar' title='Eliminar' data-toggle=\"modal\" data-target=\"#modalEliminarContacto\" type=\"button\" class=\"btn btn-danger\"><i class=\"far fa-trash-alt\"></i></button>");
						out.println("</td>");
							
					out.println("</tr>");
				}
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
