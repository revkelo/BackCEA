package com.Carritos.AcademiaCarros.Model.MySQL1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Instructor")
public class Instructor {
	
	@Id
	@Column(name = "ID_Instructor")
	private int id_instructor;
	
	@Column(name = "Cedula")
	private int Cedula;
	
	@Column(name= "Nombre")
	private String nombre;

	@Column(name= "Apellido")
	private String apellido;
	
	@Column(name= "Correo")
	private String correo;
	
	@Column(name= "Telefono")
	private String telefono;
	
	@Column(name= "Tipo_instructor")
	private String tipo_instructor;
	
	@Column(name= "Disponibilidad")
	private String disponibilidad;

	/**
	 * @return the id_instructor
	 */
	public int getId_instructor() {
		return id_instructor;
	}

	/**
	 * @param id_instructor the id_instructor to set
	 */
	public void setId_instructor(int id_instructor) {
		this.id_instructor = id_instructor;
	}

	/**
	 * @return the cedula
	 */
	public int getCedula() {
		return Cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(int cedula) {
		Cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the tipo_instructor
	 */
	public String getTipo_instructor() {
		return tipo_instructor;
	}

	/**
	 * @param tipo_instructor the tipo_instructor to set
	 */
	public void setTipo_instructor(String tipo_instructor) {
		this.tipo_instructor = tipo_instructor;
	}

	/**
	 * @return the disponibilidad
	 */
	public String getDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
