package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryClaseTeorica;

@Service
public class ClaseTeoricaService {

	@Autowired
	private RepositoryClaseTeorica repository;

	public List<ClaseTeorica> getAllClaseTeorica() {
		return repository.findAll();
	}

	public Optional<ClaseTeorica> getClaseTeoricaById(int id) {
		return repository.findById(id);
	}

	public ClaseTeorica createClaseTeorica(ClaseTeorica clase) {
		return repository.save(clase);
	}

	public ClaseTeorica updateClaseTeorica(ClaseTeorica clasedetails) {
		
		return repository.save(clasedetails);
	}

	public void deleteClaseTeorica(int id) {
		repository.deleteById(id);
	}
}
