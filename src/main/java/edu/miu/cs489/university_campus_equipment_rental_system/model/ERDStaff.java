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
public class ERDStaff {

    @Id
    private String erdStaffID;

    private String name;
    private String contactNumber;

    @OneToOne
    private Address address;

    private final int maxRentalDays = 14;
    private final float lateFeePerDay = 0.20f;

    // Getters, Setters and Constructors
}
