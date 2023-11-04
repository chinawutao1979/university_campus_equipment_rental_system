package edu.miu.cs489.university_campus_equipment_rental_system.repository;

import edu.miu.cs489.university_campus_equipment_rental_system.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
//    @Query("SELECT e FROM Equipment e JOIN FETCH e.manufacturer m JOIN FETCH e.equipmentType t WHERE e.id = :id")
//    Optional<Equipment> findByIdAndFetchAssociations(@Param("id") Long id);
}
