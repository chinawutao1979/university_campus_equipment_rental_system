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
public class GraduateStudent {

    @Id
    private String graduateStudentID;
    @Column(nullable = false)
    @NotBlank(message = "GraduateStudent's name is required. And it cannot be null, empty or blank space(s)")
    private String name;
    private String contactNumber;

    @OneToOne
    private Address address;

    private final int maxRentalDays = 10;
    private final float lateFeePerDay = 0.30f;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Getters, Setters and Constructors
}
