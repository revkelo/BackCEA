package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL2.Matriculados;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryMatriculados;

@Service
public class MatriculadosService {

	 @Autowired
	    private RepositoryMatriculados repository;

	    public List<Matriculados> getAllMatriculados() {
	        return repository.findAll();
	    }

	    public Optional<Matriculados> getMatriculadosById(int id) {
	        return repository.findById(id);
	    }

	    public Matriculados createMatriculados(Matriculados matriculados) {
	        return repository.save(matriculados);
	    }

	    public Matriculados updateMatriculados(int id, Matriculados matriculadosDetails) {
	    	Matriculados matriculados = repository.findById(id).orElseThrow(() -> new RuntimeException("Matriculado not found"));
	    	matriculados.setID_cliente(matriculadosDetails.getID_cliente());
	    	matriculados.setID_categoria(matriculadosDetails.getID_categoria());
	    	matriculados.setFecha_inicio(matriculadosDetails.getFecha_inicio());
	    	matriculados.setFecha_fin(matriculadosDetails.getFecha_fin());
	       
	        return repository.save(matriculados);
	    }

	    public void deleteMatriculados(int id) {
	        repository.deleteById(id);
	    }
	    
}
