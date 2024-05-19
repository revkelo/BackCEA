package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL2.Instructor_Practico;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryInstructor_Practico;

@Service
public class InstructorPractircoService {
	 	@Autowired
	    private RepositoryInstructor_Practico repository;

	    public List<Instructor_Practico> getAllInstructors() {
	        return repository.findAll();
	    }

	    public Optional<Instructor_Practico> getInstructorById(int id) {
	        return repository.findById(id);
	    }

	    public Instructor_Practico createInstructor(Instructor_Practico instructor) {
	        return repository.save(instructor);
	    }

	    public Instructor_Practico updateInstructor(int id, Instructor_Practico instructorDetails) {
	        Instructor_Practico instructor = repository.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
	        instructor.setCedula(instructorDetails.getCedula());
	        instructor.setNombre(instructorDetails.getNombre());
	        instructor.setApellido(instructorDetails.getApellido());
	        instructor.setCorreo(instructorDetails.getCorreo());
	        instructor.setTelefono(instructorDetails.getTelefono());
	        instructor.setTipo_instructor(instructorDetails.getTipo_instructor());
	        instructor.setDisponibilidad(instructorDetails.getDisponibilidad());
	        return repository.save(instructor);
	    }

	    public void deleteInstructor(int id) {
	        repository.deleteById(id);
	    }
	    
}
