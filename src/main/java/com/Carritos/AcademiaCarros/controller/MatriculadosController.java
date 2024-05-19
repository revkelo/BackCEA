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

import com.Carritos.AcademiaCarros.Model.MySQL2.Matriculados;
import com.Carritos.AcademiaCarros.Service.MySQL2.MatriculadosService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/matriculados")  // Adjust path as needed
public class MatriculadosController {


	    @Autowired
	    private MatriculadosService service;

	    @GetMapping
	    public List<Matriculados> getAllMatriculados() {
	        return service.getAllMatriculados();
	    }

	    @GetMapping("/{id}")
	    public Optional<Matriculados> getMatriculadosById(@PathVariable int id) {
	        return service.getMatriculadosById(id);
	    }

	    @PostMapping
	    public Matriculados createMatriculados(@RequestBody Matriculados matriculadosDetails) {
	        return service.createMatriculados(matriculadosDetails);
	    }

	    @PutMapping("/{id}")
	    public Matriculados updateMatriculados(@PathVariable int id, @RequestBody Matriculados matriculadosDetails) {
	        return service.updateMatriculados(id, matriculadosDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteMatriculados(@PathVariable int id) {
	        service.deleteMatriculados(id);
	    }
	    
}
