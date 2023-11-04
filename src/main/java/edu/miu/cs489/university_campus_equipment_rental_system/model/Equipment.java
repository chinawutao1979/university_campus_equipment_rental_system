package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;
import lombok.Data;
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

    public Long getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Long equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentID=" + equipmentID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manufacturerID=" + (manufacturer != null ? manufacturer.getManufacturerID() : null) +
                ", equipmentTypeID=" + (equipmentType != null ? equipmentType.getTypeID() : null) +
                '}';
    }
}

