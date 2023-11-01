package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Student;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.StudentRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) throws ResourceNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if(studentRepository.existsById(id)) {
            student.setStudentID(String.valueOf(id));
            return studentRepository.save(student);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
        studentRepository.delete(student);
    }
}
