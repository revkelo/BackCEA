package com.Carritos.AcademiaCarros.Model.MySQL2;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculados")
public class Matriculados {

	@Id
	@Column(name = "ID_matriculado")
	private int ID_matriculado;

	@Column(name = "ID_cliente")
	private int ID_cliente;

	@Column(name = "ID_categoria")
	private int ID_categoria;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;

	/**
	 * @return the iD_matriculado
	 */
	public int getID_matriculado() {
		return ID_matriculado;
	}

	/**
	 * @param iD_matriculado the iD_matriculado to set
	 */
	public void setID_matriculado(int iD_matriculado) {
		ID_matriculado = iD_matriculado;
	}

	/**
	 * @return the iD_cliente
	 */
	public int getID_cliente() {
		return ID_cliente;
	}

	/**
	 * @param iD_cliente the iD_cliente to set
	 */
	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}

	/**
	 * @return the iD_categoria
	 */
	public int getID_categoria() {
		return ID_categoria;
	}

	/**
	 * @param iD_categoria the iD_categoria to set
	 */
	public void setID_categoria(int iD_categoria) {
		ID_categoria = iD_categoria;
	}

	/**
	 * @return the fecha_inicio
	 */
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	/**
	 * @param fecha_inicio the fecha_inicio to set
	 */
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	/**
	 * @return the fecha_fin
	 */
	public Date getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * @param fecha_fin the fecha_fin to set
	 */
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	
	
}
