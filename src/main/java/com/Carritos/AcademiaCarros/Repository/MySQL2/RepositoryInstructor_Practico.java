package com.Carritos.AcademiaCarros.Repository.MySQL2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Carritos.AcademiaCarros.Model.MySQL2.Instructor_Practico;
import com.Carritos.AcademiaCarros.Model.MySQL2.Instructor_Teorico;

public interface RepositoryInstructor_Practico extends JpaRepository<Instructor_Practico, Integer>{

}