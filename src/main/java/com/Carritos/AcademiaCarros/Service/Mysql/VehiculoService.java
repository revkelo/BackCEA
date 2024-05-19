package com.Carritos.AcademiaCarros.Service.Mysql;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carritos.AcademiaCarros.Model.MySQL1.Vehiculo; // Replace with actual package name
import com.Carritos.AcademiaCarros.Repository.MySQL1.RepositoryVehiculo; // Replace with actual repository interface name

@Service
public class VehiculoService {

    @Autowired
    private RepositoryVehiculo repository;

    public List<Vehiculo> getAllVehiculos() {
        return repository.findAll();
    }

    public Optional<Vehiculo> getVehiculoById(int id) {
        return repository.findById(id);
    }

    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    public Vehiculo updateVehiculo(int id, Vehiculo vehiculoDetails) {
        Vehiculo vehiculo = repository.findById(id).orElseThrow(() -> new RuntimeException("Vehiculo not found"));
        vehiculo.setPlaca(vehiculoDetails.getPlaca());
        vehiculo.setModelo(vehiculoDetails.getModelo());
        vehiculo.setTipoVehiculo(vehiculoDetails.getTipoVehiculo());
        vehiculo.setMarca(vehiculoDetails.getMarca());
        vehiculo.setNivelVehiculo(vehiculoDetails.getNivelVehiculo());
        vehiculo.setDisponibilidad(vehiculoDetails.getDisponibilidad());
        return repository.save(vehiculo);
    }

    public void deleteVehiculo(int id) {
        repository.deleteById(id);
    }
}