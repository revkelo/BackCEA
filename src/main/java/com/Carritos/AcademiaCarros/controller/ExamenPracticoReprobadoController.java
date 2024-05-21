package com.Carritos.AcademiaCarros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_PracticoReprobado; 
import com.Carritos.AcademiaCarros.Service.Mysql.ExamenPracticoReprobadoService; 



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/examen-practico-reprobado")  // Adjust path as needed
public class ExamenPracticoReprobadoController {

    @Autowired
    private ExamenPracticoReprobadoService service;
    
    @GetMapping
    public List<Examen_PracticoReprobado> getAllExamenesPracticos() {
        return service.getAllExamenesPracticos();
    }


}