package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.ERDStaff;

import java.util.List;

public interface ERDStaffService {
    List<ERDStaff> getAllERDStaffMembers();
    ERDStaff getERDStaffMemberById(Long id) throws ResourceNotFoundException;
    ERDStaff createERDStaffMember(ERDStaff staffMember);
    ERDStaff updateERDStaffMember(Long id, ERDStaff staffMember);
    void deleteERDStaffMember(Long id) throws ResourceNotFoundException;
}
