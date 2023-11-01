package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.EquipmentType;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.EquipmentTypeRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public List<EquipmentType> getAllEquipmentTypes() {
        return equipmentTypeRepository.findAll();
    }

    @Override
    public EquipmentType getEquipmentTypeById(Long id) throws ResourceNotFoundException {
        return equipmentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentType not found for this id :: " + id));
    }

    @Override
    public EquipmentType createEquipmentType(EquipmentType equipmentType) {
        return equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public EquipmentType updateEquipmentType(Long id, EquipmentType equipmentType) {
        if(equipmentTypeRepository.existsById(id)) {
            equipmentType.setTypeID(id);
            return equipmentTypeRepository.save(equipmentType);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteEquipmentType(Long id) throws ResourceNotFoundException {
        EquipmentType equipmentType = equipmentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentType not found for this id :: " + id));
        equipmentTypeRepository.delete(equipmentType);
    }
}
