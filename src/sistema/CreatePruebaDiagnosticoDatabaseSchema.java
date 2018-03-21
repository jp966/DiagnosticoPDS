package sistema;
/**
 * Licensee: 
 * License Type: Evaluation
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
