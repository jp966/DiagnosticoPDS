package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import sistema.Contacto;
import sistema.ContactoDAO;
import sistema.PruebaDiagnosticoPersistentManager;

/**
 * Servlet implementation class AgregaContacto
 */
@WebServlet("/AgregaContacto")
public class AgregaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregaContacto() {
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
	 * Agrega un nuevo contacto a partir de toda la información básica del mismo, obtenida
	 * desde de los parámetros la petición.
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
		
		//Contacto contacto = ContactoDAO.createContacto();
		Contacto contacto = new Contacto();
		
		/*
		String[] parts = fechaNacimiento.split("-");
		String dia = parts[0]; // 004
		String mesAnio = parts[1]; // 034556
		
		String[] parts2 = mesAnio.split("-");
		String mes = parts2[0];
		String anio = parts2[1];
		*/
		
		try {
			Date fecha = new SimpleDateFormat("MM/dd/yyyy").parse(fechaNacimiento);
			contacto.setNombre(nombre);
			contacto.setApellido(apellido);
			contacto.setRun(run);
			contacto.setMail(mail);
			contacto.setDireccion(direccion);
			contacto.setTelefono(telefono);
			contacto.setFechaNacimiento(fecha);
			contacto.setLugarResidencia(lugarResidencia);
			contacto.setOrganizacion(organizacion);
			contacto.setFoto(foto);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ContactoDAO.save(contacto);
			//ContactoDAO.refresh(contacto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(nombre+" "+apellido+" "+run+" "+mail+" "+direccion+" "+telefono+" "+fechaNacimiento+" "+lugarResidencia+" "+organizacion+" "+foto);
		
		
	}

}
