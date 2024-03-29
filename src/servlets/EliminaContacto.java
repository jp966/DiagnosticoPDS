package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import sistema.Anotacion;
import sistema.AnotacionDAO;
import sistema.Contacto;
import sistema.ContactoDAO;
import sistema.PruebaDiagnosticoPersistentManager;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminaContacto")
public class EliminaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaContacto() {
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
	 * Elimina un contacto a través de la id obtenida de un parámetro de la petición,
	 * y todas las anotaciones asociadas al mismo.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idContacto = request.getParameter("idContacto");
		Contacto contacto;
		try {
			//Thread.sleep(2000);
			contacto = ContactoDAO.loadContactoByORMID(Integer.parseInt(idContacto));
			Anotacion[] anotaciones = AnotacionDAO.listAnotacionByQuery("contactoid="+idContacto, null);
			for(int i=0;i<anotaciones.length;i++) {
				AnotacionDAO.deleteAndDissociate(anotaciones[i]);
				
			}
			ContactoDAO.deleteAndDissociate(contacto);
		} catch (NumberFormatException | PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
