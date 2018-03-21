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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AnotacionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression titulo;
	public final StringExpression contenido;
	public final DateExpression fecha;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	
	public AnotacionDetachedCriteria() {
		super(Anotacion.class, AnotacionCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.id", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
	}
	
	public AnotacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AnotacionCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.id", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("contacto"));
	}
	
	public Anotacion uniqueAnotacion(PersistentSession session) {
		return (Anotacion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Anotacion[] listAnotacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
	}
}

