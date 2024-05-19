package com.Carritos.AcademiaCarros.Service.MySQL2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.Carritos.AcademiaCarros.Model.MySQL2.Categoria;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryCategoria;

@Service
public class CategoriaService {

	
	private RepositoryCategoria repository;
	
	
	 public List<Categoria> getAllCategoria() {
	        return repository.findAll();
	    }

	    public Optional<Categoria> getClaseCategoriaById(int id) {
	        return repository.findById(id);
	    }

	    public Categoria createCategoria(Categoria categoria) {
	        return repository.save(categoria);
	    }

	    public Categoria updateCategoria(int id, Categoria categoriaDetails) {
	    	Categoria categoria = repository.findById(id).orElseThrow(() -> new RuntimeException("Clase practica not found"));
	    	categoria.setiD_categoria(categoriaDetails.getiD_categoria());
	    	categoria.setNombre_categoria(categoriaDetails.getNombre_categoria());
	    	categoria.setHoras_practicas(categoriaDetails.getHoras_practicas());
	    	categoria.setHoras_teoricas(categoriaDetails.getNombre_categoria());
	    	categoria.setPrecio(categoriaDetails.getPrecio());
	        return repository.save(categoria);
	    }
	    public void deleteCategoria(int id) {
	        repository.deleteById(id);
	    }
}
