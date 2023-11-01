package edu.miu.cs489.university_campus_equipment_rental_system.controller;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.GraduateStudent;
import edu.miu.cs489.university_campus_equipment_rental_system.service.GraduateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/graduate-students")
public class GraduateStudentController {

    @Autowired
    private GraduateStudentService graduateStudentService;

    @GetMapping
    public ResponseEntity<List<GraduateStudent>> getAllGraduateStudents() {
        return ResponseEntity.ok(graduateStudentService.getAllGraduateStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GraduateStudent> getGraduateStudentById(@PathVariable Long id) throws ResourceNotFoundException {
        GraduateStudent student = graduateStudentService.getGraduateStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<GraduateStudent> createGraduateStudent(@RequestBody GraduateStudent student) {
        return ResponseEntity.ok(graduateStudentService.createGraduateStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GraduateStudent> updateGraduateStudent(@PathVariable Long id, @RequestBody GraduateStudent student) {
        return ResponseEntity.ok(graduateStudentService.updateGraduateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGraduateStudent(@PathVariable Long id) {
        graduateStudentService.deleteGraduateStudent(id);
        return ResponseEntity.noContent().build();
    }
}

