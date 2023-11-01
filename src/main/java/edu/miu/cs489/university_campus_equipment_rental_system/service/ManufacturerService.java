package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> getAllManufacturers();
    Manufacturer getManufacturerById(Long id) throws ResourceNotFoundException;
    Manufacturer createManufacturer(Manufacturer manufacturer);
    Manufacturer updateManufacturer(Long id, Manufacturer manufacturer);
    void deleteManufacturer(Long id) throws ResourceNotFoundException;
}
