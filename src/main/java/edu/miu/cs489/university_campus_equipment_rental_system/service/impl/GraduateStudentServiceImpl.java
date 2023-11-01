package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.GraduateStudent;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.GraduateStudentRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.GraduateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateStudentServiceImpl implements GraduateStudentService {

    @Autowired
    private GraduateStudentRepository graduateStudentRepository;

    @Override
    public List<GraduateStudent> getAllGraduateStudents() {
        return graduateStudentRepository.findAll();
    }

    @Override
    public GraduateStudent getGraduateStudentById(Long id) throws ResourceNotFoundException {
        return graduateStudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Graduate student not found for this id :: " + id));
    }

    @Override
    public GraduateStudent createGraduateStudent(GraduateStudent student) {
        return graduateStudentRepository.save(student);
    }

    @Override
    public GraduateStudent updateGraduateStudent(Long id, GraduateStudent student) {
        if(graduateStudentRepository.existsById(id)) {
            student.setGraduateStudentID(String.valueOf(id));
            return graduateStudentRepository.save(student);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteGraduateStudent(Long id) throws ResourceNotFoundException {
        GraduateStudent student = graduateStudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Graduate student not found for this id :: " + id));
        graduateStudentRepository.delete(student);
    }
}
