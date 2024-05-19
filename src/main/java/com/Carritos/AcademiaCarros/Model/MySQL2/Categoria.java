package com.Carritos.AcademiaCarros.Model.MySQL2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@Column(name = "ID_categoria")
	private int iD_categoria;
	
	@Column(name = "nombre_categoria")
	private String nombre_categoria;
	
	@Column(name = "precio")
	private int precio;
	
	@Column(name = "horas_teoricas")
	private String horas_teoricas;
	
	@Column(name = "horas_practicas")
	private String horas_practicas;

	/**
	 * @return the iD_categoria
	 */
	public int getiD_categoria() {
		return iD_categoria;
	}

	/**
	 * @param iD_categoria the iD_categoria to set
	 */
	public void setiD_categoria(int iD_categoria) {
		this.iD_categoria = iD_categoria;
	}

	/**
	 * @return the nombre_categoria
	 */
	public String getNombre_categoria() {
		return nombre_categoria;
	}

	/**
	 * @param nombre_categoria the nombre_categoria to set
	 */
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the horas_teoricas
	 */
	public String getHoras_teoricas() {
		return horas_teoricas;
	}

	/**
	 * @param horas_teoricas the horas_teoricas to set
	 */
	public void setHoras_teoricas(String horas_teoricas) {
		this.horas_teoricas = horas_teoricas;
	}

	/**
	 * @return the horas_practicas
	 */
	public String getHoras_practicas() {
		return horas_practicas;
	}

	/**
	 * @param horas_practicas the horas_practicas to set
	 */
	public void setHoras_practicas(String horas_practicas) {
		this.horas_practicas = horas_practicas;
	}	
	
	

}
