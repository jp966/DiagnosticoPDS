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
		try {
			Contacto[] arrayContactos = ContactoDAO.listContactoByQuery(null,null);
			//Usuario[] usuarios = UsuarioDAO.listUsuarioByQuery(null,null);
			
			List<Contacto> contactos = new ArrayList<Contacto>();
			
			for(int i=0;i<arrayContactos.length;i++) {
				contactos.add(arrayContactos[i]);
			}
			
			String saludo = "hola";
			 //String json = new Gson().toJson(arrayContactos);
			 //System.out.println(json);
		
			request.getSession().setAttribute("contactos", arrayContactos);
			request.getRequestDispatcher("contactos.jsp").forward(request, response);
			
			
			//response.setContentType("application/json");
			//response.setCharacterEncoding("UTF-8");
			//response.getWriter().write(json);
			//response.getWriter().close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("salto exception");
		} 
	}

}
