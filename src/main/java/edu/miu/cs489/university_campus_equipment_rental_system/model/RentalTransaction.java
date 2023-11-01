package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RentalTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionID;

    // Considering the member who rents can be any of the four types
    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private ERDStaff erdStaff;

    @ManyToOne
    private GraduateStudent graduateStudent;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Equipment equipment;

    private Date rentalDate;
    private Date dueDate;
    private Date returnDate;
    private Float lateFee;

    // Getters, Setters, and other boilerplate
}

