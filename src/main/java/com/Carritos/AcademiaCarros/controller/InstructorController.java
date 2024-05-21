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

import com.Carritos.AcademiaCarros.Model.MySQL1.Instructor;
import com.Carritos.AcademiaCarros.Service.Mysql.InstructorService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return service.getAllInstructors();
    }

    @GetMapping("/{cedula}")
    public Optional<Instructor> getInstructorByCedula(@PathVariable int cedula) {
        return service.getInstructorByCedula(cedula);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return service.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable int id, @RequestBody Instructor instructorDetails) {
        return service.updateInstructor(id, instructorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable int cedula) {
        service.deleteInstructorbyCedula(cedula);
    }
}
