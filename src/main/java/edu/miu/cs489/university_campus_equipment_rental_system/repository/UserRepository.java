package edu.miu.cs489.university_campus_equipment_rental_system.repository;


import edu.miu.cs489.university_campus_equipment_rental_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public abstract Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);


}
