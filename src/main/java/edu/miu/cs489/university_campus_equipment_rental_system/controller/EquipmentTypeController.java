package edu.miu.cs489.university_campus_equipment_rental_system.controller;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.EquipmentType;
import edu.miu.cs489.university_campus_equipment_rental_system.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment-types")
public class EquipmentTypeController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @GetMapping
    public ResponseEntity<List<EquipmentType>> getAllEquipmentTypes() {
        return ResponseEntity.ok(equipmentTypeService.getAllEquipmentTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentType> getEquipmentTypeById(@PathVariable Long id) throws ResourceNotFoundException {
        EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(id);
        return ResponseEntity.ok().body(equipmentType);
    }

    @PostMapping
    public ResponseEntity<EquipmentType> createEquipmentType(@RequestBody EquipmentType equipmentType) {
        return ResponseEntity.ok(equipmentTypeService.createEquipmentType(equipmentType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentType> updateEquipmentType(@PathVariable Long id, @RequestBody EquipmentType equipmentType) {
        return ResponseEntity.ok(equipmentTypeService.updateEquipmentType(id, equipmentType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipmentType(@PathVariable Long id) {
        equipmentTypeService.deleteEquipmentType(id);
        return ResponseEntity.noContent().build();
    }
}
