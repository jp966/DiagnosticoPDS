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
 * Servlet implementation class ValidaRunContacto
 */
@WebServlet("/ValidaRunContacto")
public class ValidaRunContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaRunContacto() {
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
		
		String run = request.getParameter("run");
		String operacion = request.getParameter("operacion");
		
		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();
		try {
			
			if(operacion.equals("editar")) {
				
				String id = request.getParameter("idContacto");
				
				if(ContactoDAO.loadContactoByQuery("id !='"+id+"' and run = '"+run+"'", null)!=null) {
					System.out.println("existe");
					out.print("true");
				}else if (ContactoDAO.loadContactoByQuery("id !='"+id+"' and run = '"+run+"'", null)==null) {
					out.print("false");
				}
				
			}else if(operacion.equals("crear")) {
				
				if(ContactoDAO.loadContactoByQuery("run = '"+run+"'", null)!=null) {
					System.out.println("existe");
					out.print("true");
				}else if (ContactoDAO.loadContactoByQuery("run = '"+run+"'", null)==null) {
					out.print("false");
				}
				
			}
			
			
			
			
			
			
			
			
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}