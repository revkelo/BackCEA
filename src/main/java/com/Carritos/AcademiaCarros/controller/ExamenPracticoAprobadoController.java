package com.Carritos.AcademiaCarros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_PracticoAprobado; 
import com.Carritos.AcademiaCarros.Service.Mysql.ExamenPracticoAprobadoService; 



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/examen-practico-aprobado")  // Adjust path as needed
public class ExamenPracticoAprobadoController {

    @Autowired
    private ExamenPracticoAprobadoService service;
    
    @GetMapping
    public List<Examen_PracticoAprobado> getAllExamenesPracticos() {
        return service.getAllExamenesPracticos();
    }


}