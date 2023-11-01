package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipments();
    Equipment getEquipmentById(Long id) throws ResourceNotFoundException;
    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Long id, Equipment equipment);
    void deleteEquipment(Long id) throws ResourceNotFoundException;
}
