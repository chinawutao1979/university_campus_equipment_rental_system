package edu.miu.cs489.university_campus_equipment_rental_system.service;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.RentalTransaction;

import java.util.List;

public interface RentalTransactionService {
    List<RentalTransaction> getAllTransactions();
    RentalTransaction getTransactionById(Long id) throws ResourceNotFoundException;
    RentalTransaction createTransaction(RentalTransaction transaction);
    RentalTransaction updateTransaction(Long id, RentalTransaction transaction);
    void deleteTransaction(Long id) throws ResourceNotFoundException;
}
