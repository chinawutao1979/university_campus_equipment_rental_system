package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;


import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Faculty;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.FacultyRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) throws ResourceNotFoundException {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found for this id :: " + id));
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        if(facultyRepository.existsById(id)) {
            faculty.setFacultyID(String.valueOf(id));
            return facultyRepository.save(faculty);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteFaculty(Long id) throws ResourceNotFoundException {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found for this id :: " + id));
        facultyRepository.delete(faculty);
    }
}
