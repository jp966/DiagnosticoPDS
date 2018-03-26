package sistema;
/**
 * Licensee: juan(Universidad de La Frontera)
 * License Type: Academic
 */
import org.orm.*;
public class ListPruebaDiagnosticoData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Anotacion...");
		Anotacion[] anotacions = AnotacionDAO.listAnotacionByQuery(null, null);
		int length = Math.min(anotacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(anotacions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Contacto...");
		Contacto[] contactos = ContactoDAO.listContactoByQuery(null, null);
		length = Math.min(contactos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(contactos[i].getNombre());
		}
		System.out.println(length + " record(s) retrieved.");
	
		
		System.out.println("Listing Usuario...");
		Usuario[] usuarios = UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(usuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(usuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Anotacion by Criteria...");
		AnotacionCriteria anotacionCriteria = new AnotacionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//anotacionCriteria.id.eq();
		anotacionCriteria.setMaxResults(ROW_COUNT);
		Anotacion[] anotacions = anotacionCriteria.listAnotacion();
		int length =anotacions== null ? 0 : Math.min(anotacions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(anotacions[i]);
		}
		System.out.println(length + " Anotacion record(s) retrieved."); 
		
		System.out.println("Listing Contacto by Criteria...");
		ContactoCriteria contactoCriteria = new ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//contactoCriteria.id.eq();
		contactoCriteria.setMaxResults(ROW_COUNT);
		Contacto[] contactos = contactoCriteria.listContacto();
		length =contactos== null ? 0 : Math.min(contactos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(contactos[i]);
		}
		System.out.println(length + " Contacto record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		UsuarioCriteria usuarioCriteria = new UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//usuarioCriteria.id.eq();
		usuarioCriteria.setMaxResults(ROW_COUNT);
		Usuario[] usuarios = usuarioCriteria.listUsuario();
		length =usuarios== null ? 0 : Math.min(usuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(usuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListPruebaDiagnosticoData listPruebaDiagnosticoData = new ListPruebaDiagnosticoData();
			try {
				listPruebaDiagnosticoData.listTestData();
				//listPruebaDiagnosticoData.listByCriteria();
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
