package com.Carritos.AcademiaCarros.Model.MySQL2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "examenpractico_aprobado")
public class Examen_PracticoAprobados {
	
	@Id
	@Column(name = "ID_examen")
	private int iD_examen;
	
	@Column(name = "ID_matriculados")	
	private int iD_matriculados;
	
	@Column(name = "ID_instructor")
	private int iD_instructor;	
	
	@Column(name = "ID_vehiculo")
	private int iD_vehiculo;	
	
	@Column(name = "resultado")
	private String resultado;

	/**
	 * @return the iD_examen
	 */
	public int getiD_examen() {
		return iD_examen;
	}

	/**
	 * @param iD_examen the iD_examen to set
	 */
	public void setiD_examen(int iD_examen) {
		this.iD_examen = iD_examen;
	}

	/**
	 * @return the iD_matriculados
	 */
	public int getiD_matriculados() {
		return iD_matriculados;
	}

	/**
	 * @param iD_matriculados the iD_matriculados to set
	 */
	public void setiD_matriculados(int iD_matriculados) {
		this.iD_matriculados = iD_matriculados;
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
	 * @return the iD_vehiculo
	 */
	public int getiD_vehiculo() {
		return iD_vehiculo;
	}

	/**
	 * @param iD_vehiculo the iD_vehiculo to set
	 */
	public void setiD_vehiculo(int iD_vehiculo) {
		this.iD_vehiculo = iD_vehiculo;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
