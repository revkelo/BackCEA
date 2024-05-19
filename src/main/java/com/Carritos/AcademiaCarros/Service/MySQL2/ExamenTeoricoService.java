package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL2.ExamenTeorico;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryExamenTeorico;

@Service
public class ExamenTeoricoService {

	    @Autowired
	    private RepositoryExamenTeorico repository;

	    public List<ExamenTeorico> getAllExamenesTeoricos() {
	        return repository.findAll();
	    }

	    public Optional<ExamenTeorico> getExamenTeoricoById(int id) {
	        return repository.findById(id);
	    }

	    public ExamenTeorico createExamenTeorico(ExamenTeorico examenTeorico) {
	        return repository.save(examenTeorico);
	    }

	    public ExamenTeorico updateExamenTeorico(int id, ExamenTeorico examenTeoricoDetails) {
	    	ExamenTeorico examenTeorico = repository.findById(id).orElseThrow(() -> new RuntimeException("Examen teorico not found"));
	    	examenTeorico.setID_matriculados(examenTeoricoDetails.getID_matriculados());
	    	examenTeorico.setResultado(examenTeoricoDetails.getResultado());
	       
	        return repository.save(examenTeorico);
	    }

	    public void deleteExamenTeorico(int id) {
	        repository.deleteById(id);
	    }
	}
	

