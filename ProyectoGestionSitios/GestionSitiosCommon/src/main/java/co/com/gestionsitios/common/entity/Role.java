package co.com.gestionsitios.common.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40, nullable = false, unique = true)
	private String nombre;
	
	@Column(length = 150, nullable = false, unique = true)
	private String descripcion;

	public Role() {
		super();
	}
	
	public Role(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Role(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
