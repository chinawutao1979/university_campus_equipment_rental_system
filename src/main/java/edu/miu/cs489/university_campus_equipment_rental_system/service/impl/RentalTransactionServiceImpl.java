package edu.miu.cs489.university_campus_equipment_rental_system.service.impl;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.RentalTransaction;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.RentalTransactionRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.service.RentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalTransactionServiceImpl implements RentalTransactionService {

    @Autowired
    private RentalTransactionRepository transactionRepository;

    @Override
    public List<RentalTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public RentalTransaction getTransactionById(Long id) throws ResourceNotFoundException {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
    }

    @Override
    public RentalTransaction createTransaction(RentalTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public RentalTransaction updateTransaction(Long id, RentalTransaction transaction) {
        if(transactionRepository.existsById(id)) {
            transaction.setTransactionID(id);
            return transactionRepository.save(transaction);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteTransaction(Long id) throws ResourceNotFoundException {
        RentalTransaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
        transactionRepository.delete(transaction);
    }
}
