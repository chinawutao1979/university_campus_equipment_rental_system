package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Manufacturer;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.ManufacturerRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(Long id) throws ResourceNotFoundException {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found for this id :: " + id));
    }

    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Long id, Manufacturer manufacturer) {
        if(manufacturerRepository.existsById(id)) {
            manufacturer.setManufacturerID(id);
            return manufacturerRepository.save(manufacturer);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteManufacturer(Long id) throws ResourceNotFoundException {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found for this id :: " + id));
        manufacturerRepository.delete(manufacturer);
    }
}
