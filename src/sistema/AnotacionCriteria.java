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
 * Licensee: 
 * License Type: Evaluation
 */
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AnotacionCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression titulo;
	public final StringExpression contenido;
	public final DateExpression fecha;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	
	public AnotacionCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		titulo = new StringExpression("titulo", this);
		contenido = new StringExpression("contenido", this);
		fecha = new DateExpression("fecha", this);
		contactoId = new IntegerExpression("contacto.id", this);
		contacto = new AssociationExpression("contacto", this);
	}
	
	public AnotacionCriteria(PersistentSession session) {
		this(session.createCriteria(Anotacion.class));
	}
	
	public AnotacionCriteria() throws PersistentException {
		this(PruebaDiagnosticoPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("contacto"));
	}
	
	public Anotacion uniqueAnotacion() {
		return (Anotacion) super.uniqueResult();
	}
	
	public Anotacion[] listAnotacion() {
		java.util.List list = super.list();
		return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
	}
}

