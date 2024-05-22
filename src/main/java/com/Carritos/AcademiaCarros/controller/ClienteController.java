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
import com.Carritos.AcademiaCarros.Model.Oracle.Cliente;
import com.Carritos.AcademiaCarros.Service.Oracle.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<Cliente> getAllCliente() {
		return service.getAllCliente();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> getClienteById(@PathVariable int id) {
		return service.getClienteById(id);
	}


	@GetMapping("/{id}/nombre")
	public String getNombreClienteById(@PathVariable int id) {
		return service.getNombreClienteById(id);
	}
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {

		return service.createCliente(cliente);
	}
	

	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable int id, @RequestBody Cliente clienteDetails) {
		return service.updateCliente(id, clienteDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable int id) {
		service.deleteCliente(id);
	}


}
