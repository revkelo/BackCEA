//package com.Carritos.AcademiaCarros.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Carritos.AcademiaCarros.Model.MariaDB.PersonaM;
//import com.Carritos.AcademiaCarros.Model.Oracle.PersonaO;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/databases2")
//public class PersonaController {
//
//    @Qualifier("mysqlEMF")
//    @Autowired
//    private EntityManager mysqlEM;
//
//    @Qualifier("oracleEMF")
//    @Autowired
//    private EntityManager oracleEM;
//
//    @PostMapping("/PersonaMySQL")
//    @Transactional("mysqlTrxManager")
//    public void registrarPersonaMySQL(@RequestBody String nombre) {
//        PersonaM nuevo = new PersonaM();
//        nuevo.setNombre(nombre);
//        mysqlEM.persist(nuevo);
//    }
//
//    @GetMapping("/listarPersonasMySQL")
//    public List<PersonaM> listarPersonasMySQL() {
//        String jpql = "SELECT p FROM PersonaM p";
//        Query query = mysqlEM.createQuery(jpql);
//        return query.getResultList();
//    }
//
//    @PostMapping("/PersonaOracle")
//    @Transactional("oracleTrxManager")
//    public void registrarPersonaOracle(@RequestBody String nombre) {
//        PersonaO nuevo = new PersonaO();
//        nuevo.setNombre(nombre);
//        oracleEM.persist(nuevo);
//    }
//
//    @GetMapping("/listarPersonasOracle")
//    public List<PersonaO> listarPersonasOracle() {
//        String jpql = "SELECT p FROM PersonaO p";
//        Query query = oracleEM.createQuery(jpql);
//        return query.getResultList();
//    }
//}
