package sistema;
/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class DeletePruebaDiagnosticoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = PruebaDiagnosticoPersistentManager.instance().getSession().beginTransaction();
		try {
			Anotacion anotacion = AnotacionDAO.loadAnotacionByQuery(null, null);
			// Delete the persistent object
			AnotacionDAO.delete(anotacion);
			Contacto contacto = ContactoDAO.loadContactoByQuery(null, null);
			// Delete the persistent object
			ContactoDAO.delete(contacto);
			Usuario usuario = UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			UsuarioDAO.delete(usuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeletePruebaDiagnosticoData deletePruebaDiagnosticoData = new DeletePruebaDiagnosticoData();
			try {
				deletePruebaDiagnosticoData.deleteTestData();
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
