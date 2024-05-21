package com.Carritos.AcademiaCarros.Service.Mysql;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 // Replace with actual package name
import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_PracticoAprobado;
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryExamen_PracticoAprobado; // Replace with actual repository interface name

@Service
public class ExamenPracticoAprobadoService {

    @Autowired
    private RepositoryExamen_PracticoAprobado repository;

    public List<Examen_PracticoAprobado> getAllExamenesPracticos() {
        return repository.findAll();
    }

}