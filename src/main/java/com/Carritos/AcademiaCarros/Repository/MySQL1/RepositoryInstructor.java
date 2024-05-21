package com.Carritos.AcademiaCarros.Repository.MySQL1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Carritos.AcademiaCarros.Model.MySQL1.Instructor;




public interface RepositoryInstructor extends JpaRepository<Instructor, Integer>{

	
	public Optional<Instructor> findByCedula(Integer Cedula);
	public Optional<Instructor> deleteByCedula(Integer Cedula);
}
