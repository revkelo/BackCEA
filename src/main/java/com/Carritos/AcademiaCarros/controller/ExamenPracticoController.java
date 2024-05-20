package com.Carritos.AcademiaCarros.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_Practico; // Replace with actual package name
import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Service.Mysql.ExamenPracticoService; // Replace with actual service name

import jakarta.persistence.EntityManager;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/examen-practico")  // Adjust path as needed
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
    
    @PostMapping("/agregar")
   	public ResponseEntity<String> agregar(@RequestParam int ID_instructor, @RequestParam int ID_matriculado,
   			@RequestParam int ID_vehiculo, @RequestParam String resultado) {
    	Examen_Practico temp = new Examen_Practico();
   		temp.setiD_vehiculo(ID_vehiculo);
   		temp.setiD_instructor(ID_instructor);
   		temp.setiD_matriculados(ID_matriculado);
   		temp.setResultado(resultado);

   		service.createExamenPractico(temp);
   		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con Ã©xito: 201");
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