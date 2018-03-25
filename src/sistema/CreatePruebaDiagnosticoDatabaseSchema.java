package sistema;
/**
 * Licensee: juan(Universidad de La Frontera)
 * License Type: Academic
 */
import org.orm.*;
public class CreatePruebaDiagnosticoDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(PruebaDiagnosticoPersistentManager.instance());
			PruebaDiagnosticoPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
