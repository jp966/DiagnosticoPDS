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
public class Anotacion {
	public Anotacion() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ANOTACION_CONTACTO) {
			this.contacto = (Contacto) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private String titulo;
	
	private String contenido;
	
	private java.util.Date fecha;
	
	private Contacto contacto;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setContenido(String value) {
		this.contenido = value;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	public void setContacto(Contacto value) {
		if (contacto != null) {
			contacto.anotacion.remove(this);
		}
		if (value != null) {
			value.anotacion.add(this);
		}
	}
	
	public Contacto getContacto() {
		return contacto;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Contacto(Contacto value) {
		this.contacto = value;
	}
	
	private Contacto getORM_Contacto() {
		return contacto;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
