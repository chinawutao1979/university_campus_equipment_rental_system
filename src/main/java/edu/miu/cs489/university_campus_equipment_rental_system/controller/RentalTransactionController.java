package edu.miu.cs489.university_campus_equipment_rental_system.controller;

import edu.miu.cs489.university_campus_equipment_rental_system.exception.ResourceNotFoundException;
import edu.miu.cs489.university_campus_equipment_rental_system.model.RentalTransaction;
import edu.miu.cs489.university_campus_equipment_rental_system.service.RentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class RentalTransactionController {

    @Autowired
    private RentalTransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<RentalTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalTransaction> getTransactionById(@PathVariable Long id) throws ResourceNotFoundException {
        RentalTransaction transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok().body(transaction);
    }

    @PostMapping
    public ResponseEntity<RentalTransaction> createTransaction(@RequestBody RentalTransaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalTransaction> updateTransaction(@PathVariable Long id, @RequestBody RentalTransaction transaction) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}

