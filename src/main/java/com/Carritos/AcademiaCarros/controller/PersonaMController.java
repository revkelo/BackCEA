package com.Carritos.AcademiaCarros.controller;

import com.Carritos.AcademiaCarros.Model.MariaDB.PersonaM;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mysql")
public class PersonaMController {

    @Autowired
    @Qualifier("mysqlEMF")
    private EntityManager mysqlEM;

    @PostMapping("/persona")
    @Transactional("mysqlTrxManager")
    public String createPersonaM(@RequestBody String nombre) {
        PersonaM persona = new PersonaM();
        persona.setNombre(nombre);
        mysqlEM.persist(persona);
        return "PersonaM created successfully";
    }

    @GetMapping("/personas")
    @Transactional("mysqlTrxManager")
    public List<PersonaM> getAllPersonasM() {
        return mysqlEM.createQuery("SELECT p FROM PersonaM p", PersonaM.class).getResultList();
    }
}
