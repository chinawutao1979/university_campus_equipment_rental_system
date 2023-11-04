package edu.miu.cs489.university_campus_equipment_rental_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
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

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public ERDStaff getErdStaff() {
        return erdStaff;
    }

    public void setErdStaff(ERDStaff erdStaff) {
        this.erdStaff = erdStaff;
    }

    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Float getLateFee() {
        return lateFee;
    }

    public void setLateFee(Float lateFee) {
        this.lateFee = lateFee;
    }

    // Getters, Setters, and other boilerplate
}

