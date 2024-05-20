package com.Carritos.AcademiaCarros.Model.Oracle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq_gen")
    @SequenceGenerator(name = "cliente_seq_gen", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "CEDULA", nullable = false)
    private Long cedula;

	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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
	 * @return the cedula
	 */
	public Long getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

    // Getters y setters
}
