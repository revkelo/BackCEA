package com.Carritos.AcademiaCarros.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_Practico; // Replace with actual package name
import com.Carritos.AcademiaCarros.Service.Mysql.ExamenPracticoService; // Replace with actual service name

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/examen-practico")  // Adjust path as needed
public class ExamenPracticoController {

    @Autowired
    private ExamenPracticoService service;

    @GetMapping
    public List<Examen_Practico> getAllExamenesPracticos() {
        return service.getAllExamenesPracticos();
    }

    @GetMapping("/{id}")
    public Optional<Examen_Practico> getExamenPracticoById(@PathVariable int id) {
        return service.getExamenPracticoById(id);
    }

    @PostMapping
    public Examen_Practico createExamenPractico(@RequestBody Examen_Practico examenPractico) {
        return service.createExamenPractico(examenPractico);
    }

    @PutMapping("/{id}")
    public Examen_Practico updateExamenPractico(@PathVariable int id, @RequestBody Examen_Practico examenPracticoDetails) {
        return service.updateExamenPractico(id, examenPracticoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExamenPractico(@PathVariable int id) {
        service.deleteExamenPractico(id);
    }
}