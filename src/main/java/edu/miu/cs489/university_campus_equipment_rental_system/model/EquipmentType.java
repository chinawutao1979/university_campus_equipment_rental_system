package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeID;
    private String name;

    @OneToMany(mappedBy = "equipmentType")
    private List<Equipment> equipments = new ArrayList<>();

    // Getters, Setters, and other boilerplate
}

