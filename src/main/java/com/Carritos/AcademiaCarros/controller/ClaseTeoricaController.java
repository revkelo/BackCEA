
package com.Carritos.AcademiaCarros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Service.MySQL2.ClaseTeoricaService;

import jakarta.persistence.EntityManager;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/claseteorica")
public class ClaseTeoricaController {
	
	@Autowired
	private ClaseTeoricaService service;

	@GetMapping
	public List<ClaseTeorica> getAllClaseTeorica() {
		return service.getAllClaseTeorica();
	}

	@GetMapping("/{id}")
	public Optional<ClaseTeorica> getClaseTeoricaById(@PathVariable int id) {
		return service.getClaseTeoricaById(id);
	}

	@PostMapping("/Agregar")
	public ResponseEntity<String> agregar(@RequestParam int ID_instructor, @RequestParam int ID_matriculado,
			@RequestParam String Descripcion) {
		ClaseTeorica temp = new ClaseTeorica();
		temp.setDescripcion(Descripcion);
		temp.setiD_instructor(ID_instructor);
		temp.setiD_matriculado(ID_matriculado);

		service.createClaseTeorica(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con Ã©xito: 201");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateClaseTeorica(@RequestParam int id, @RequestParam int ID_instructor,
			@RequestParam int ID_matriculado, @RequestParam String Descripcion) {
		ClaseTeorica clase = service.getClaseTeoricaById(id).orElseThrow(() -> new RuntimeException("Clase teorica not found"));
		clase.setiD_claseT(id);
		clase.setiD_instructor(ID_instructor);
		clase.setiD_matriculado(ID_matriculado);
		clase.setDescripcion(Descripcion);
		service.updateClaseTeorica(clase);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con Ã©xito: 201");
	}

	@DeleteMapping("/{id}")
	public void deleteClaseTeorica(@PathVariable int id) {
		service.deleteClaseTeorica(id);
	}
}
