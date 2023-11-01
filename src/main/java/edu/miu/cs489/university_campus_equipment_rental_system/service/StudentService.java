package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id) throws ResourceNotFoundException;
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id) throws ResourceNotFoundException;
}
