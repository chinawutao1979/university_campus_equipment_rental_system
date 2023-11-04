package edu.miu.cs489.university_campus_equipment_rental_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeID;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentType")
    private List<Equipment> equipments = new ArrayList<>();

    // Getters, Setters, and other boilerplate
    @Override
    public String toString() {
        return "EquipmentType{" +
                "typeID=" + typeID +
                ", name='" + name + '\'' +
                ", equipments=" + equipments.stream()
                .map(Equipment::getEquipmentID)
                .collect(Collectors.toList()) +
                '}';
    }
}

