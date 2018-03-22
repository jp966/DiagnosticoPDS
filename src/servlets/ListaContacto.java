package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import com.google.gson.Gson;

import sistema.Contacto;
import sistema.ContactoDAO;

import sistema.Usuario;
import sistema.UsuarioDAO;

/**
 * Servlet implementation class ListaContacto
 */
@WebServlet("/ListaContacto")
public class ListaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaContacto() {
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
		
		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();
		
		try {
			Contacto[] arrayContactos = ContactoDAO.listContactoByQuery(null,null);
			

			for (int i = 0; i < arrayContactos.length; i++) {
				out.println("<tr>");
				
					out.println("<td style='display:none;'><span id='idContacto'>" + arrayContactos[i].getORMID() + "</span></td>");
					out.println("<td>" + arrayContactos[i].getNombre() + "</td>");
					out.println("<td>" + arrayContactos[i].getApellido() + "</td>");
					out.println("<td>" + arrayContactos[i].getRun() + "</td>");
					out.println("<td>" + arrayContactos[i].getTelefono() + "</td>");
					out.println("<td>" + arrayContactos[i].getMail() + "</td>");
					out.println("<td>");
						out.println("<button title='Bitácora' type=\"button\" class=\"btn\" style=\"background-color: #ff8533\"><i class=\"far fa-address-book\" style=\"color:white;\"></i></button>");
						out.println("<button title='Editar' type=\"button\" class=\"btn\" style=\"background-color:#009999;\"><i class=\"far fa-edit\" style=\"color:white;\"></i></button>");
						out.println("<button id='eliminar' title='Eliminar' data-toggle=\"modal\" data-target=\"#modalEliminarContacto\" type=\"button\" class=\"btn btn-danger\"><i class=\"far fa-trash-alt\"></i></button>");
					out.println("</td>");
						
				out.println("</tr>");
			}
		
		
		
			//request.getSession().setAttribute("contactos", arrayContactos);
			//request.getRequestDispatcher("contactos.jsp").forward(request, response);
			
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("salto exception");
		} 
	}

}
