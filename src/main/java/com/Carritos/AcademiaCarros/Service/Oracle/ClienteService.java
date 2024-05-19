package com.Carritos.AcademiaCarros.Service.Oracle;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.Carritos.AcademiaCarros.Model.MySQL2.ClaseTeorica;
import com.Carritos.AcademiaCarros.Model.Oracle.Cliente;
import com.Carritos.AcademiaCarros.Repository.MySQL2.RepositoryClaseTeorica;
import com.Carritos.AcademiaCarros.Repository.Oracle.RepositoryCliente;

@Service
public class ClienteService {

	
	private RepositoryCliente repository;
	
	
	 public List<Cliente> getAllCliente() {
	        return repository.findAll();
	    }

	    public Optional<Cliente> getClienteById(int id) {
	        return repository.findById(id);
	    }

	    public Cliente createCliente(Cliente cliente) {
	        return repository.save(cliente);
	    }

	    public Cliente updateCliente(int id, Cliente clienteDetails) {
	    	Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("Clase practica not found"));
	    	cliente.setId_cliente(clienteDetails.getId_cliente());
	    	cliente.setNombre(clienteDetails.getNombre());
	    	cliente.setApellido(clienteDetails.getApellido());
	    	cliente.setCorreo(clienteDetails.getCorreo());
	    	cliente.setTelefono(clienteDetails.getTelefono());
	    	cliente.setCedula(clienteDetails.getCedula());
	        return repository.save(cliente);
	    }
	    public void deleteCliente(int id) {
	        repository.deleteById(id);
	    }
}
