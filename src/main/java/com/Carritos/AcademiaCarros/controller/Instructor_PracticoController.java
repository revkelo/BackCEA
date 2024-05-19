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
import com.Carritos.AcademiaCarros.Service.MySQL2.InstructorPracticoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/instructor-practico")
public class Instructor_PracticoController {

    @Autowired
    private InstructorPracticoService service;

    @GetMapping
    public List<Instructor_Practico> getAllInstructors() {
        return service.getAllInstructors();
    }

    @GetMapping("/{id}")
    public Optional<Instructor_Practico> getInstructorById(@PathVariable int id) {
        return service.getInstructorById(id);
    }

    @PostMapping("/Agregarinstructor-practico")
    public Instructor_Practico createInstructor(@RequestBody Instructor_Practico instructor) {
        return service.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor_Practico updateInstructor(@PathVariable int id, @RequestBody Instructor_Practico instructorDetails) {
        return service.updateInstructor(id, instructorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable int id) {
        service.deleteInstructor(id);
    }
}
