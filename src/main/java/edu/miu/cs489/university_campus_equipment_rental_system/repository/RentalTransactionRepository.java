package edu.miu.cs489.university_campus_equipment_rental_system.repository;

import edu.miu.cs489.university_campus_equipment_rental_system.model.RentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Long> {
}
