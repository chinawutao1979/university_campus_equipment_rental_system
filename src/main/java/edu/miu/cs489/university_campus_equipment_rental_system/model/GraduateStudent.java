package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GraduateStudent {

    @Id
    private String graduateStudentID;

    private String name;
    private String contactNumber;

    @OneToOne
    private Address address;

    private final int maxRentalDays = 10;
    private final float lateFeePerDay = 0.30f;

    // Getters, Setters and Constructors
}
