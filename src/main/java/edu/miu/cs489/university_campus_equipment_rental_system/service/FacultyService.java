package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty getFacultyById(Long id) throws ResourceNotFoundException;
    Faculty createFaculty(Faculty faculty);
    Faculty updateFaculty(Long id, Faculty faculty);
    void deleteFaculty(Long id) throws ResourceNotFoundException;
}
