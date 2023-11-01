package edu.miu.cs489.university_campus_equipment_rental_system.controller;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.ERDStaff;
import edu.miu.cs489.university_campus_equipment_rental_system.service.ERDStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/erd-staff")
public class ERDStaffController {

    @Autowired
    private ERDStaffService erdStaffService;

    @GetMapping
    public ResponseEntity<List<ERDStaff>> getAllERDStaffMembers() {
        return ResponseEntity.ok(erdStaffService.getAllERDStaffMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ERDStaff> getERDStaffMemberById(@PathVariable Long id) throws ResourceNotFoundException {
        ERDStaff staffMember = erdStaffService.getERDStaffMemberById(id);
        return ResponseEntity.ok().body(staffMember);
    }

    @PostMapping
    public ResponseEntity<ERDStaff> createERDStaffMember(@RequestBody ERDStaff staffMember) {
        return ResponseEntity.ok(erdStaffService.createERDStaffMember(staffMember));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ERDStaff> updateERDStaffMember(@PathVariable Long id, @RequestBody ERDStaff staffMember) {
        return ResponseEntity.ok(erdStaffService.updateERDStaffMember(id, staffMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteERDStaffMember(@PathVariable Long id) {
        erdStaffService.deleteERDStaffMember(id);
        return ResponseEntity.noContent().build();
    }
}
