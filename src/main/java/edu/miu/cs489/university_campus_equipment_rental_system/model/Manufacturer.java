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
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerID;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address headOfficeAddress;
    private String contactNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer")
    private List<Equipment> equipments = new ArrayList<>();

    // Getters, Setters, and other boilerplate
    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerID=" + manufacturerID +
                ", name='" + name + '\'' +
                ", headOfficeAddress=" + (headOfficeAddress != null ? headOfficeAddress.toString() : null) +
                ", contactNumber='" + contactNumber + '\'' +
                ", equipments=" + equipments.stream().map(Equipment::getEquipmentID).collect(Collectors.toList()) +
                '}';
    }
}


