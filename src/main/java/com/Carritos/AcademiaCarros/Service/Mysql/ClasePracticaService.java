package com.Carritos.AcademiaCarros.Service.Mysql;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL1.ClasePractica; // Replace with actual package name
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryClasePractica; // Replace with actual repository interface name


@Service
public class ClasePracticaService {

    @Autowired
    private RepositoryClasePractica repository;

    public List<ClasePractica> getAllClasesPracticas() {
        return repository.findAll();
    }

    public Optional<ClasePractica> getClasePracticaById(int id) {
        return repository.findById(id);
    }

    public ClasePractica createClasePractica(ClasePractica clasePractica) {
        return repository.save(clasePractica);
    }

    public ClasePractica updateClasePractica(ClasePractica clasePracticaDetails) {
    	
        return repository.save(clasePracticaDetails);
    }
    public void deleteClasePractica(int id) {
        repository.deleteById(id);
    }
}