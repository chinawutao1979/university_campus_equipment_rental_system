package edu.miu.cs489.university_campus_equipment_rental_system.repository;


import edu.miu.cs489.university_campus_equipment_rental_system.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}