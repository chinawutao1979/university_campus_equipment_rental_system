package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class Student {

    @Id
    private String studentID;
    @Column(nullable = false)
    @NotBlank(message = "Student's name is required. And it cannot be null, empty or blank space(s)")
    private String name;
    private String contactNumber;

    @OneToOne
    private Address address;

    private final int maxRentalDays = 7;
    private final float lateFeePerDay = 0.50f;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Getters, Setters and Constructors
}
