package sistema;
/**
 * Licensee: juan(Universidad de La Frontera)
 * License Type: Academic
 */
import org.orm.*;
public class CreatePruebaDiagnosticoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = PruebaDiagnosticoPersistentManager.instance().getSession().beginTransaction();
		try {
			Anotacion anotacion = AnotacionDAO.createAnotacion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contacto, fecha, contenido, titulo
			AnotacionDAO.save(anotacion);
			Contacto contacto = ContactoDAO.createContacto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : anotacion, mail, run, apellido, nombre
			ContactoDAO.save(contacto);
			Usuario usuario = UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, usuario
			UsuarioDAO.save(usuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreatePruebaDiagnosticoData createPruebaDiagnosticoData = new CreatePruebaDiagnosticoData();
			try {
				createPruebaDiagnosticoData.createTestData();
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
