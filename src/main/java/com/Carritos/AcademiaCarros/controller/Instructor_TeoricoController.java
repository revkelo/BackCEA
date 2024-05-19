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

import com.Carritos.AcademiaCarros.Model.MySQL2.Instructor_Practico;
import com.Carritos.AcademiaCarros.Model.MySQL2.Instructor_Teorico;
import com.Carritos.AcademiaCarros.Service.MySQL2.InstructorPractircoService;
import com.Carritos.AcademiaCarros.Service.MySQL2.InstructorTeoricoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/instructor-practico")
public class Instructor_TeoricoController {

    @Autowired
    private InstructorTeoricoService service;

    @GetMapping
    public List<Instructor_Teorico> getAllInstructors() {
        return service.getAllInstructors();
    }

    @GetMapping("/{id}")
    public Optional<Instructor_Teorico> getInstructorById(@PathVariable int id) {
        return service.getInstructorById(id);
    }

    @PostMapping
    public Instructor_Teorico createInstructor(@RequestBody Instructor_Teorico instructor) {
        return service.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor_Teorico updateInstructor(@PathVariable int id, @RequestBody Instructor_Teorico instructorDetails) {
        return service.updateInstructor(id, instructorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable int id) {
        service.deleteInstructor(id);
    }
}
