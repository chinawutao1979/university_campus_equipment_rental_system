package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Address;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.AddressRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) throws ResourceNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        if(addressRepository.existsById(id)) {
            address.setId(id);
            return addressRepository.save(address);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteAddress(Long id) throws ResourceNotFoundException {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
        addressRepository.delete(address);
    }
}
