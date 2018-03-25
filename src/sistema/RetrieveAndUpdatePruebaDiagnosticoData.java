package sistema;
/**
 * Licensee: juan(Universidad de La Frontera)
 * License Type: Academic
 */
import org.orm.*;
public class RetrieveAndUpdatePruebaDiagnosticoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = PruebaDiagnosticoPersistentManager.instance().getSession().beginTransaction();
		try {
			Anotacion anotacion = AnotacionDAO.loadAnotacionByQuery(null, null);
			// Update the properties of the persistent object
			AnotacionDAO.save(anotacion);
			Contacto contacto = ContactoDAO.loadContactoByQuery(null, null);
			// Update the properties of the persistent object
			ContactoDAO.save(contacto);
			Usuario usuario = UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			UsuarioDAO.save(usuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Anotacion by AnotacionCriteria");
		AnotacionCriteria anotacionCriteria = new AnotacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//anotacionCriteria.id.eq();
		System.out.println(anotacionCriteria.uniqueAnotacion());
		
		System.out.println("Retrieving Contacto by ContactoCriteria");
		ContactoCriteria contactoCriteria = new ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//contactoCriteria.id.eq();
		System.out.println(contactoCriteria.uniqueContacto());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		UsuarioCriteria usuarioCriteria = new UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//usuarioCriteria.id.eq();
		System.out.println(usuarioCriteria.uniqueUsuario());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdatePruebaDiagnosticoData retrieveAndUpdatePruebaDiagnosticoData = new RetrieveAndUpdatePruebaDiagnosticoData();
			try {
				retrieveAndUpdatePruebaDiagnosticoData.retrieveAndUpdateTestData();
				//retrieveAndUpdatePruebaDiagnosticoData.retrieveByCriteria();
			}
			finally {
				PruebaDiagnosticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
