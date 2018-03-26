package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import sistema.ListPruebaDiagnosticoData;
import sistema.Usuario;
import sistema.UsuarioDAO;

/**
 * Servlet implementation class IngresoSistema
 */
@WebServlet("/IngresoSistema")
public class IngresoSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoSistema() {
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
	 * Valida que las credenciales sean válidas
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String respuesta="";
		String nombreUsuario = request.getParameter("nombreUsuario");
		String password = request.getParameter("password");
		
		//response.setContentType("application/json");
	    //response.setCharacterEncoding("UTF-8");
		
		System.out.println(nombreUsuario+' '+password);
		
		if(!nombreUsuario.equals("") && !password.equals("")) {
			//respuesta="false";
			//response.getWriter().print(false);
			//response.getWriter().close();
			//System.out.println(false);
		//}else{
			try {
				Usuario usuario = UsuarioDAO.loadUsuarioByQuery("usuario='"+nombreUsuario+"'", null);
								
				//Si el usuario existe y la clave es corecta
				if(usuario!=null && usuario.getPassword().equals(password)) {
					//respuesta="{'esValido':true}";
					//response.setContentType("application/json");
				    //response.setCharacterEncoding("UTF-8");
					response.getWriter().print(true);
					//response.getWriter().close();
					//System.out.println("true");
					
				}else {
					//respuesta="{'esValido':false}";
					//response.setContentType("application/json");
				    //response.setCharacterEncoding("UTF-8");
					response.getWriter().print(false);
					//response.getWriter().close();
					//System.out.println("false");
				}
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//response.setContentType("text/plain");
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");
		
		
	
	}
	
}
