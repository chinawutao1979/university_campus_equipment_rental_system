package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Equipment;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.EquipmentRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getEquipmentById(Long id) throws ResourceNotFoundException {
        //Optional<Equipment> e = equipmentRepository.findByIdAndFetchAssociations(id);
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found for this id :: " + id));
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Long id, Equipment equipment) {
        if(equipmentRepository.existsById(id)) {
            equipment.setEquipmentID(id);
            return equipmentRepository.save(equipment);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteEquipment(Long id) throws ResourceNotFoundException {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found for this id :: " + id));
        equipmentRepository.delete(equipment);
    }
}
