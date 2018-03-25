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
public class Contacto {
	public Contacto() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CONTACTO_ANOTACION) {
			return ORM_anotacion;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String run;
	
	private String mail;
	
	private String direccion;
	
	private String telefono;
	
	private java.util.Date fechaNacimiento;
	
	private String lugarResidencia;
	
	private String organizacion;
	
	private String foto;
	
	private java.util.Set ORM_anotacion = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setRun(String value) {
		this.run = value;
	}
	
	public String getRun() {
		return run;
	}
	
	public void setMail(String value) {
		this.mail = value;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setFechaNacimiento(java.util.Date value) {
		this.fechaNacimiento = value;
	}
	
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setLugarResidencia(String value) {
		this.lugarResidencia = value;
	}
	
	public String getLugarResidencia() {
		return lugarResidencia;
	}
	
	public void setOrganizacion(String value) {
		this.organizacion = value;
	}
	
	public String getOrganizacion() {
		return organizacion;
	}
	
	public void setFoto(String value) {
		this.foto = value;
	}
	
	public String getFoto() {
		return foto;
	}
	
	private void setORM_Anotacion(java.util.Set value) {
		this.ORM_anotacion = value;
	}
	
	private java.util.Set getORM_Anotacion() {
		return ORM_anotacion;
	}
	
	public final AnotacionSetCollection anotacion = new AnotacionSetCollection(this, _ormAdapter, ORMConstants.KEY_CONTACTO_ANOTACION, ORMConstants.KEY_ANOTACION_CONTACTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
