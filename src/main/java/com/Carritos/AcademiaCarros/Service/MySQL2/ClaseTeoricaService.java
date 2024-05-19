package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryClaseTeorica;

@Service
public class ClaseTeoricaService {

	
	private RepositoryClaseTeorica repository;
	
	
	 public List<ClaseTeorica> getAllClasesTeoricas() {
	        return repository.findAll();
	    }

	    public Optional<ClaseTeorica> getClaseTeoricasById(int id) {
	        return repository.findById(id);
	    }

	    public ClaseTeorica createClaseTeoricas(ClaseTeorica clase) {
	        return repository.save(clase);
	    }

	    public ClaseTeorica updateClaseTeoricas(int id, ClaseTeorica clasedetails) {
	    	ClaseTeorica clase = repository.findById(id).orElseThrow(() -> new RuntimeException("Clase teorica not found"));
	    	clase.setiD_claseT(clasedetails.getiD_claseT());
	    	clase.setiD_instructor(clasedetails.getiD_instructor());
	    	clase.setiD_matriculado(clasedetails.getiD_matriculado());
	    	clase.setDescripcion(clasedetails.getDescripcion());
	        return repository.save(clase);
	    }
	    public void deleteClaseTeoricas(int id) {
	        repository.deleteById(id);
	    }
}
