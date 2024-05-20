package com.Carritos.AcademiaCarros.Service.Mysql;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_Practico; // Replace with actual package name
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryExamen_Practico; // Replace with actual repository interface name

@Service
public class ExamenPracticoService {

    @Autowired
    private RepositoryExamen_Practico repository;

    public List<Examen_Practico> getAllExamenesPracticos() {
        return repository.findAll();
    }

    public Optional<Examen_Practico> getExamenPracticoById(int id) {
        return repository.findById(id);
    }

    public Examen_Practico createExamenPractico(Examen_Practico examenPractico) {
        return repository.save(examenPractico);
    }

    public Examen_Practico updateExamenPractico(Examen_Practico examenPracticoDetails) {
       
       
        return repository.save(examenPracticoDetails);
    }

    public void deleteExamenPractico(int id) {
        repository.deleteById(id);
    }
}