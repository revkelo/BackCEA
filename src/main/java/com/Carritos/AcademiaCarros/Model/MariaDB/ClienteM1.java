package com.Carritos.AcademiaCarros.Model.MariaDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class ClienteM1 {

	@Id
	@Column(name = "ID_cliente")
	private int idCliente;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellido")
	private String apellido;

	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "Correo")
	private String correo;

	@Column(name = "Cedula")
	private int cedula;

	// Getters y Setters

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
}
