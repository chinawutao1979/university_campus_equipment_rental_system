package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Long id) throws ResourceNotFoundException;
    Address createAddress(Address address);
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id) throws ResourceNotFoundException;
}
