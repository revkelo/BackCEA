package com.Carritos.AcademiaCarros.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.Carritos.AcademiaCarros.Model.MySQL1.Examen_Practico;
import com.Carritos.AcademiaCarros.Model.MySQL2.ExamenTeorico;
import com.Carritos.AcademiaCarros.Service.MySQL2.ExamenTeoricoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/examen-teorico")  // Adjust path as needed
public class ExamenTeoricoController {

    @Autowired
    private ExamenTeoricoService service;

    @GetMapping
    public List<ExamenTeorico> getAllExamenesTeoricos() {
        return service.getAllExamenesTeoricos();
    }

    @GetMapping("/{id}")
    public Optional<ExamenTeorico> getExamenTeoricoById(@PathVariable int id) {
        return service.getExamenTeoricoById(id);
    }

    @PostMapping("/agregar")
   	public ResponseEntity<String> agregar(@RequestParam int ID_matriculado,@RequestParam String resultado) {
    	ExamenTeorico temp = new ExamenTeorico();
   		temp.setID_matriculados(ID_matriculado);
   		temp.setResultado(resultado);

   		service.createExamenTeorico(temp);
   		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con Ã©xito: 201");
   	}

    @PutMapping("/{id}")
    public ExamenTeorico updateExamenTeorico(@PathVariable int id, @RequestBody ExamenTeorico examenTeoricoDetails) {
        return service.updateExamenTeorico(id, examenTeoricoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExamenTeorico(@PathVariable int id) {
        service.deleteExamenTeorico(id);
    }
}