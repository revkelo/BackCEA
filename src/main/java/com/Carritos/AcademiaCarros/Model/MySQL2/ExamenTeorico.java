package com.Carritos.AcademiaCarros.Model.MySQL2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "examenteorico")
public class ExamenTeorico {

	@Id
	@Column(name = "ID_examenT")
	private int ID_examenT;

	@Column(name = "ID_matriculados")
	private int ID_matriculados;

	@Column(name = "resultado")
	private String resultado;



	/**
	 * @return the iD_examenT
	 */
	public int getID_examenT() {
		return ID_examenT;
	}

	/**
	 * @param iD_examenT the iD_examenT to set
	 */
	public void setID_examenT(int iD_examenT) {
		ID_examenT = iD_examenT;
	}

	/**
	 * @return the iD_matriculados
	 */
	public int getID_matriculados() {
		return ID_matriculados;
	}

	/**
	 * @param iD_matriculados the iD_matriculados to set
	 */
	public void setID_matriculados(int iD_matriculados) {
		ID_matriculados = iD_matriculados;
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