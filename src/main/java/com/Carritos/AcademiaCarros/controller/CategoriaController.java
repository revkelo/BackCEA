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


import com.Carritos.AcademiaCarros.Model.MySQL2.Categoria;
import com.Carritos.AcademiaCarros.Service.MySQL2.CategoriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	  public List<Categoria> getAllCategoria() {
        return service.getAllCategoria();
    }
	
	@GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable int id) {
        return service.getCategoriaById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return service.createCategoria(categoria);
    }
    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable int id, @RequestBody Categoria categoriaDetails) {
        return service.updateCategoria(id, categoriaDetails);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable int id) {
        service.deleteCategoria(id);
    }
	
	
}
