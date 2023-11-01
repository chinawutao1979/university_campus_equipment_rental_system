package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.ERDStaff;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.ERDStaffRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.ERDStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ERDStaffServiceImpl implements ERDStaffService {

    @Autowired
    private ERDStaffRepository erdStaffRepository;

    @Override
    public List<ERDStaff> getAllERDStaffMembers() {
        return erdStaffRepository.findAll();
    }

    @Override
    public ERDStaff getERDStaffMemberById(Long id) throws ResourceNotFoundException {
        return erdStaffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ERDStaff member not found for this id :: " + id));
    }

    @Override
    public ERDStaff createERDStaffMember(ERDStaff staffMember) {
        return erdStaffRepository.save(staffMember);
    }

    @Override
    public ERDStaff updateERDStaffMember(Long id, ERDStaff staffMember) {
        if(erdStaffRepository.existsById(id)) {
            staffMember.setErdStaffID(String.valueOf(id));
            return erdStaffRepository.save(staffMember);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteERDStaffMember(Long id) throws ResourceNotFoundException {
        ERDStaff staffMember = erdStaffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ERDStaff member not found for this id :: " + id));
        erdStaffRepository.delete(staffMember);
    }
}
