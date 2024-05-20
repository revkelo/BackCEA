package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryClaseT;

@Service
public class ClaseTeoricaService {

	private RepositoryClaseT repo;
	
	
	 public List<ClaseTeorica> getAllClaseTeorica() {
	        return repo.findAll();
	    }

	    public Optional<ClaseTeorica> getClaseTeoricaById(int id) {
	        return repo.findById(id);
	    }

	    public ClaseTeorica createClaseTeorica(ClaseTeorica clase) {
	        return repo.save(clase);
	    }

	    public ClaseTeorica updateClaseTeorica(int id, ClaseTeorica clasedetails) {
	    	ClaseTeorica clase = repo.findById(id).orElseThrow(() -> new RuntimeException("Clase teorica not found"));
	    	clase.setiD_claseT(clasedetails.getiD_claseT());
	    	clase.setiD_instructor(clasedetails.getiD_instructor());
	    	clase.setiD_matriculado(clasedetails.getiD_matriculado());
	    	clase.setDescripcion(clasedetails.getDescripcion());
	        return repo.save(clase);
	    }
	    public void deleteClaseTeorica(int id) {
	    	repo.deleteById(id);
	    }
}
