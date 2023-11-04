package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs489.university_campus_equipment_rental_system.service.StudentService;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Student;

@SpringBootTest
@ActiveProfiles("test") // Assuming you have a 'test' profile for testing
@Transactional // To rollback transactions after tests
public class StudentServiceIntegrationTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateAndGetStudent() {
//        Student student = new Student();
//        student.setName("John Doe");
//        Student savedStudent = studentService.createStudent(student);
//
//        assertNotNull(savedStudent.getStudentID());

        Student retrievedStudent = studentService.getStudentById(1l);
        assertNotNull(retrievedStudent.getStudentID());
        //assertEquals("John Doe", retrievedStudent.getName());
    }

    // Add more integration tests for other methods in a similar fashion...
}
