package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import sistema.ContactoDAO;
import sistema.Contacto;
import sistema.Anotacion;
import sistema.AnotacionDAO;

/**
 * Servlet implementation class BitacoraContacto
 */
@WebServlet("/BitacoraContacto")
public class BitacoraContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitacoraContacto() {
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
		
		try {
			Contacto contacto = ContactoDAO.loadContactoByORMID(Integer.parseInt(idContacto));
			
			if(operacion.equals("obtenerAnotaciones")) {
				response.setContentType("text/plain");

				PrintWriter out = response.getWriter();
				Anotacion[] anotaciones = AnotacionDAO.listAnotacionByQuery("contactoid="+Integer.parseInt(idContacto), null);
				
				for(int i=0;i<anotaciones.length;i++) {
					out.println("<div class=\"card\" style=\"width: 22rem; margin-bottom:5px; margin-top:5px;\">\n" + 
							"				  <div class=\"card-body\">\n" + 
							"				    <h5 class=\"card-title\">"+anotaciones[i].getTitulo()+"</h5>\n" + 
							"				    <h6 class=\"card-subtitle mb-2 text-muted\">"+anotaciones[i].getFecha().getDate()+" / "+(anotaciones[i].getFecha().getMonth()+1)+" / "+(anotaciones[i].getFecha().getYear()+1900)+"</h6>\n" + 
							"				    <p class=\"card-text\">"+anotaciones[i].getContenido()+"</p>\n" + 
							"				   \n" + 
							"				  </div>\n" + 
							"				</div>");
				}
				
				
			}else if(operacion.equals("crearAnotacion")) {
				
				String titulo = request.getParameter("titulo");
				String contenido = request.getParameter("contenido");
				Date fechaActual=new Date();
				Anotacion anotacion = AnotacionDAO.createAnotacion();
				anotacion.setTitulo(titulo);
				anotacion.setContenido(contenido);
				anotacion.setFecha(new Date((fechaActual.getYear()),(fechaActual.getMonth()),fechaActual.getDate()));
				anotacion.setContacto(contacto);
				
				AnotacionDAO.save(anotacion);
				AnotacionDAO.refresh(anotacion);
				
			}
		
		
		
		
		
		} catch (NumberFormatException | PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

}
