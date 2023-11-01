package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.EquipmentType;

import java.util.List;

public interface EquipmentTypeService {
    List<EquipmentType> getAllEquipmentTypes();
    EquipmentType getEquipmentTypeById(Long id) throws ResourceNotFoundException;
    EquipmentType createEquipmentType(EquipmentType equipmentType);
    EquipmentType updateEquipmentType(Long id, EquipmentType equipmentType);
    void deleteEquipmentType(Long id) throws ResourceNotFoundException;
}
