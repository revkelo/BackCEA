package com.Carritos.AcademiaCarros.Service.Mysql;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 // Replace with actual package name
import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_PracticoReprobado;
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryExamen_PracticoReprobado; // Replace with actual repository interface name

@Service
public class ExamenPracticoReprobadoService {

    @Autowired
    private RepositoryExamen_PracticoReprobado repository;

    public List<Examen_PracticoReprobado> getAllExamenesPracticos() {
        return repository.findAll();
    }
    
}