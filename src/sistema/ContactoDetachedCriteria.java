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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ContactoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public ContactoDetachedCriteria() {
		super(Contacto.class, ContactoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		mail = new StringExpression("mail", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fechaNacimiento = new DateExpression("fechaNacimiento", this.getDetachedCriteria());
		lugarResidencia = new StringExpression("lugarResidencia", this.getDetachedCriteria());
		organizacion = new StringExpression("organizacion", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
		anotacion = new CollectionExpression("ORM_Anotacion", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ContactoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		mail = new StringExpression("mail", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fechaNacimiento = new DateExpression("fechaNacimiento", this.getDetachedCriteria());
		lugarResidencia = new StringExpression("lugarResidencia", this.getDetachedCriteria());
		organizacion = new StringExpression("organizacion", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
		anotacion = new CollectionExpression("ORM_Anotacion", this.getDetachedCriteria());
	}
	
	public AnotacionDetachedCriteria createAnotacionCriteria() {
		return new AnotacionDetachedCriteria(createCriteria("ORM_Anotacion"));
	}
	
	public Contacto uniqueContacto(PersistentSession session) {
		return (Contacto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Contacto[] listContacto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

