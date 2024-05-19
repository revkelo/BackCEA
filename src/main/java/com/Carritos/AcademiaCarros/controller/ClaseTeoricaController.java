
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

import com.Carritos.AcademiaCarros.Model.MySQL1.ClasePractica;
import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Service.MySQL2.ClaseTeoricaService;
import com.Carritos.AcademiaCarros.Service.Mysql.ClasePracticaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clase-teorica")
public class ClaseTeoricaController {
    @Autowired
    private ClaseTeoricaService service;

    @GetMapping
    public List<ClaseTeorica> getAllClasesTeorica() {
        return service.getAllClasesTeoricas();
    }

    @GetMapping("/{id}")
    public Optional<ClaseTeorica> getClaseTeoricaById(@PathVariable int id) {
        return service.getClaseTeoricasById(id);
    }

    @PostMapping
    public ClaseTeorica createClaseTeorica(@RequestBody ClaseTeorica claseTeorica) {
        return service.createClaseTeoricas(claseTeorica);
    }
    @PutMapping("/{id}")
    public ClaseTeorica updateClaseTeorica(@PathVariable int id, @RequestBody ClaseTeorica claseTeoricaDetails) {
        return service.updateClaseTeoricas(id, claseTeoricaDetails);
    }
    
    @DeleteMapping("/{id}")
    public void deleteClaseTeorica(@PathVariable int id) {
        service.deleteClaseTeoricas(id);
    }
}
