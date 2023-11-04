package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import edu.miu.cs489.university_campus_equipment_rental_system.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.miu.cs489.university_campus_equipment_rental_system.service.impl.StudentServiceImpl;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.StudentRepository;
import java.util.Arrays;
import java.util.Optional;

public class StudentServiceUnitTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));

        assertEquals(2, studentService.getAllStudents().size());
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student();
        student.setStudentID("1");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        assertEquals(student, studentService.getStudentById(1L));
    }

    // Add more unit tests for other methods in a similar fashion...
}