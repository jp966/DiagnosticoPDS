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
 * Servlet implementation class DetalleContacto
 */
@WebServlet("/DetalleContacto")
public class DetalleContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleContacto() {
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
		
		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();
		try {
			Thread.sleep(1000);
			Contacto contacto = ContactoDAO.loadContactoByORMID(Integer.parseInt(idContacto));
			System.out.println(contacto.getFechaNacimiento());
			out.println("<div>");
				out.println("<div class=\"card\" style=\"width:550px;border-style: none;display:block;\n" + 
						"    margin:auto;\">");
				out.println("<img class=\"card-img-top\" src='"+contacto.getFoto()+"' alt=\"Card image\" style=\"border-radius: 50%;display:block;\n" + 
						"    margin:auto;width:50%;heigth:50%;\">");
					
					out.println("<div class=\"card-body\">");
					
						out.println("<h4 class=\"card-title\">"+contacto.getNombre()+" "+contacto.getApellido()+" - "+"<span style='font-weight: lighter;'>"+contacto.getOrganizacion()+"</span></h4>");
						out.println("<p class=\"card-text\">");
						
						out.println("<div class='row'>");
						
							out.println("<div class='col-md-6'>");
								out.println("<span style='display:block;'><span style='font-weight: bold;'>RUN: </span>"+contacto.getRun()+"</span>");
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Mail: </span>"+contacto.getMail()+"</span>");
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Dirección: </span>"+contacto.getDireccion()+"</span>");
							out.println("</div>");
							
							out.println("<div class='col-md-6'>");
							
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Lugar residencia: </span>"+contacto.getLugarResidencia()+"</span>");
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Teléfono: </span>"+contacto.getTelefono()+"</span>");
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Fecha nacimiento: </span>"+contacto.getFechaNacimiento()+"</span>");
								
							out.println("</div>");
						
						out.println("</div>");
						/*
						out.println("<div class='row'>");
							out.println("<div class='col-md-12' style='margin-top:5px;'> <center>");
							
								out.println("<span style='display:block;'><span style='font-weight: bold;'>Organización: </span>"+contacto.getOrganizacion()+"</span>");
					    
							out.println("</center></div>");
						out.println("</div>");	
						*/
						out.println("</p>");
					out.println("</div>");
				
				out.println("</div>");
			
			out.println("</div>");
			
			out.println("<div class=\"modal-footer\">");
				out.println("<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cerrar</button>\n");
			out.println("</div>");
		
		} catch (NumberFormatException | PersistentException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
