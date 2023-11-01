package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentID;
    private String name;
    private String description;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    private EquipmentType equipmentType;

    // Getters, Setters, and other boilerplate
}

