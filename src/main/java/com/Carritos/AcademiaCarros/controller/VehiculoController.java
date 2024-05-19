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

import com.Carritos.AcademiaCarros.Model.MySQL1.Vehiculo; // Replace with actual package name
import com.Carritos.AcademiaCarros.Service.Mysql.VehiculoService; // Replace with actual service name

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehiculo")  // Adjust path as needed
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return service.getAllVehiculos();
    }

    @GetMapping("/{id}")
    public Optional<Vehiculo> getVehiculoById(@PathVariable int id) {
        return service.getVehiculoById(id);
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return service.createVehiculo(vehiculo);
    }

    @PutMapping("/{id}")
    public Vehiculo updateVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculoDetails) {
        return service.updateVehiculo(id, vehiculoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable int id) {
        service.deleteVehiculo(id);
    }
}