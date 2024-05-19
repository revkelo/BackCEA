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

import com.Carritos.AcademiaCarros.Model.MySQL1.ClasePractica; // Replace with actual package name
import com.Carritos.AcademiaCarros.Service.Mysql.ClasePracticaService; // Replace with actual service name

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clase-practica") // Adjust path as needed
public class ClasePracticaController {

    @Autowired
    private ClasePracticaService service;

    @GetMapping
    public List<ClasePractica> getAllClasesPracticas() {
        return service.getAllClasesPracticas();
    }

    @GetMapping("/{id}")
    public Optional<ClasePractica> getClasePracticaById(@PathVariable int id) {
        return service.getClasePracticaById(id);
    }

    @PostMapping
    public ClasePractica createClasePractica(@RequestBody ClasePractica clasePractica) {
        return service.createClasePractica(clasePractica);
    }
    @PutMapping("/{id}")
    public ClasePractica updateClasePractica(@PathVariable int id, @RequestBody ClasePractica clasePracticaDetails) {
        return service.updateClasePractica(id, clasePracticaDetails);
    }
    
    @DeleteMapping("/{id}")
    public void deleteClasePractica(@PathVariable int id) {
        service.deleteClasePractica(id);
    }
}