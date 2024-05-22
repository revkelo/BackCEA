package com.Carritos.AcademiaCarros.Repository.Oracle;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Carritos.AcademiaCarros.Model.Oracle.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Integer>{

	public Optional<Cliente> findByIdCliente(Integer idCliente);
	
	  default String findNombreByIdCliente(Integer idCliente) {
	        Optional<Cliente> clienteOptional = findByIdCliente(idCliente);
	        return clienteOptional.map(Cliente::getNombre).orElse(null);
	    }
}
