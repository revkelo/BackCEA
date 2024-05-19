package com.Carritos.AcademiaCarros.Model.MySQL2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "claseteorica")
public class ClaseTeorica {

	
	@Id
	@Column(name = "ID_claseT")
	private int iD_claseT;
	
	@Column(name = "ID_instructor")
	private int iD_instructor;
	
	@Column(name = "ID_matriculado")
	private int iD_matriculado;
	
	@Column(name = "descripcion")
	private String descripcion;

	/**
	 * @return the iD_claseT
	 */
	public int getiD_claseT() {
		return iD_claseT;
	}

	/**
	 * @param iD_claseT the iD_claseT to set
	 */
	public void setiD_claseT(int iD_claseT) {
		this.iD_claseT = iD_claseT;
	}

	/**
	 * @return the iD_instructor
	 */
	public int getiD_instructor() {
		return iD_instructor;
	}

	/**
	 * @param iD_instructor the iD_instructor to set
	 */
	public void setiD_instructor(int iD_instructor) {
		this.iD_instructor = iD_instructor;
	}

	/**
	 * @return the iD_matriculado
	 */
	public int getiD_matriculado() {
		return iD_matriculado;
	}

	/**
	 * @param iD_matriculado the iD_matriculado to set
	 */
	public void setiD_matriculado(int iD_matriculado) {
		this.iD_matriculado = iD_matriculado;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
	
}
