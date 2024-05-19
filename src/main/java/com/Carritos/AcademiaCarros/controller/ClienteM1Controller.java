package com.Carritos.AcademiaCarros.controller;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.Carritos.AcademiaCarros.Model.MariaDB.ClienteM1;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sql")
public class ClienteM1Controller {

    @Autowired
    @Qualifier("mysqlEMF")
    private EntityManager sqlEM;

    @PostMapping("/cliente")
    @Transactional("mysqlTrxManager")
    public String createCliente(
            @RequestParam String nombre, @RequestParam String apellido, @RequestParam String telefono,
            @RequestParam String correo, @RequestParam int cedula) {

        ClienteM1 cliente = new ClienteM1();

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setCedula(cedula);

        sqlEM.persist(cliente);
        return "Cliente creado exitosamente";
    }

    @GetMapping("/cliente")
    @Transactional("mysqlTrxManager")
    public List<ClienteM1> getAllClientes() {
        return sqlEM.createQuery("SELECT c FROM ClienteM1 c", ClienteM1.class).getResultList();
    }

    @PutMapping("/cliente/{id}")
    @Transactional("mysqlTrxManager")
    public String updateCliente(
            @PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String telefono,
            @RequestParam String correo,
            @RequestParam int cedula) {

        ClienteM1 cliente = sqlEM.find(ClienteM1.class, id);
        if (cliente == null) {
            return "Cliente no encontrado";
        }

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setCedula(cedula);

        sqlEM.merge(cliente);
        return "Cliente actualizado exitosamente";
    }

    @DeleteMapping("/cliente/{id}")
    @Transactional("mysqlTrxManager")
    public String deleteCliente(@PathVariable Long id) {
        ClienteM1 cliente = sqlEM.find(ClienteM1.class, id);
        if (cliente == null) {
            return "Cliente no encontrado";
        }

        sqlEM.remove(cliente);
        return "Cliente eliminado exitosamente";
    }
}
