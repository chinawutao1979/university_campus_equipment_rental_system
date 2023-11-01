package edu.miu.cs489.university_campus_equipment_rental_system.repository;

import edu.miu.cs489.university_campus_equipment_rental_system.model.GraduateStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateStudentRepository extends JpaRepository<GraduateStudent, Long> {
}
