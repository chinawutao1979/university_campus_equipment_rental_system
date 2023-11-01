package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.GraduateStudent;

import java.util.List;

public interface GraduateStudentService {
    List<GraduateStudent> getAllGraduateStudents();
    GraduateStudent getGraduateStudentById(Long id) throws ResourceNotFoundException;
    GraduateStudent createGraduateStudent(GraduateStudent student);
    GraduateStudent updateGraduateStudent(Long id, GraduateStudent student);
    void deleteGraduateStudent(Long id) throws ResourceNotFoundException;
}
