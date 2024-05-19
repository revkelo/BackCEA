package com.Carritos.AcademiaCarros.controller;

import com.Carritos.AcademiaCarros.Model.Oracle.PersonaO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oracle")
public class PersonaOController {

    @Autowired
    @Qualifier("oracleEntityManager")
    private EntityManager oracleEM;

    @PostMapping("/persona")
    @Transactional("oracleTrxManager")
    public String createPersonaO(@RequestBody String nombre) {
        PersonaO persona = new PersonaO();
        persona.setNombre(nombre);
        oracleEM.persist(persona);
        return "PersonaO created successfully";
    }

    @GetMapping("/personas")
    @Transactional("oracleTrxManager")
    public List<PersonaO> getAllPersonasO() {
        return oracleEM.createQuery("SELECT p FROM PersonaO p", PersonaO.class).getResultList();
    }
}
