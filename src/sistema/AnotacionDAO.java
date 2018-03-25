package sistema;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: juan(Universidad de La Frontera)
 * License Type: Academic
 */
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AnotacionDAO {
	public static Anotacion loadAnotacionByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return loadAnotacionByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return getAnotacionByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return loadAnotacionByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return getAnotacionByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Anotacion) session.load(Anotacion.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Anotacion) session.get(Anotacion.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Anotacion) session.load(Anotacion.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Anotacion) session.get(Anotacion.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return queryAnotacion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return queryAnotacion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return listAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return listAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Anotacion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAnotacion(session, condition, orderBy);
			return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAnotacion(session, condition, orderBy, lockMode);
			return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return loadAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return loadAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Anotacion[] anotacions = listAnotacionByQuery(session, condition, orderBy);
		if (anotacions != null && anotacions.length > 0)
			return anotacions[0];
		else
			return null;
	}
	
	public static Anotacion loadAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Anotacion[] anotacions = listAnotacionByQuery(session, condition, orderBy, lockMode);
		if (anotacions != null && anotacions.length > 0)
			return anotacions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return iterateAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PruebaDiagnosticoPersistentManager.instance().getSession();
			return iterateAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Anotacion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion createAnotacion() {
		return new Anotacion();
	}
	
	public static boolean save(Anotacion anotacion) throws PersistentException {
		try {
			PruebaDiagnosticoPersistentManager.instance().saveObject(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Anotacion anotacion) throws PersistentException {
		try {
			PruebaDiagnosticoPersistentManager.instance().deleteObject(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Anotacion anotacion)throws PersistentException {
		try {
			if (anotacion.getContacto() != null) {
				anotacion.getContacto().anotacion.remove(anotacion);
			}
			
			return delete(anotacion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Anotacion anotacion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (anotacion.getContacto() != null) {
				anotacion.getContacto().anotacion.remove(anotacion);
			}
			
			try {
				session.delete(anotacion);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Anotacion anotacion) throws PersistentException {
		try {
			PruebaDiagnosticoPersistentManager.instance().getSession().refresh(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Anotacion anotacion) throws PersistentException {
		try {
			PruebaDiagnosticoPersistentManager.instance().getSession().evict(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByCriteria(AnotacionCriteria anotacionCriteria) {
		Anotacion[] anotacions = listAnotacionByCriteria(anotacionCriteria);
		if(anotacions == null || anotacions.length == 0) {
			return null;
		}
		return anotacions[0];
	}
	
	public static Anotacion[] listAnotacionByCriteria(AnotacionCriteria anotacionCriteria) {
		return anotacionCriteria.listAnotacion();
	}
}
