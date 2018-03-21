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

public class ContactoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression run;
	public final StringExpression mail;
	public final StringExpression direccion;
	public final StringExpression telefono;
	public final DateExpression fechaNacimiento;
	public final StringExpression lugarResidencia;
	public final StringExpression organizacion;
	public final StringExpression foto;
	public final CollectionExpression anotacion;
	
	public ContactoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		run = new StringExpression("run", this);
		mail = new StringExpression("mail", this);
		direccion = new StringExpression("direccion", this);
		telefono = new StringExpression("telefono", this);
		fechaNacimiento = new DateExpression("fechaNacimiento", this);
		lugarResidencia = new StringExpression("lugarResidencia", this);
		organizacion = new StringExpression("organizacion", this);
		foto = new StringExpression("foto", this);
		anotacion = new CollectionExpression("ORM_Anotacion", this);
	}
	
	public ContactoCriteria(PersistentSession session) {
		this(session.createCriteria(Contacto.class));
	}
	
	public ContactoCriteria() throws PersistentException {
		this(PruebaDiagnosticoPersistentManager.instance().getSession());
	}
	
	public AnotacionCriteria createAnotacionCriteria() {
		return new AnotacionCriteria(createCriteria("ORM_Anotacion"));
	}
	
	public Contacto uniqueContacto() {
		return (Contacto) super.uniqueResult();
	}
	
	public Contacto[] listContacto() {
		java.util.List list = super.list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

