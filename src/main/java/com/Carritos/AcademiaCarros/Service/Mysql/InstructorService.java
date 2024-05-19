package com.Carritos.AcademiaCarros.Service.Mysql;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL1.Instructor;
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryInstructor;


@Service
public class InstructorService {
	 	@Autowired
	    private RepositoryInstructor repository;

	    public List<Instructor> getAllInstructors() {
	        return repository.findAll();
	    }

	    public Optional<Instructor> getInstructorByCedula(int Cedula) {
	        return repository.findByCedula(Cedula);
	    }

	    public Instructor createInstructor(Instructor instructor) {
	        return repository.save(instructor);
	    }

	    public Instructor updateInstructor(int id, Instructor instructorDetails) {
	    	Instructor instructor = repository.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
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
