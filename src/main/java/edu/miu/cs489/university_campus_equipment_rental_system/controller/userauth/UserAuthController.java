package edu.miu.cs489.university_campus_equipment_rental_system.controller.userauth;


import edu.miu.cs489.university_campus_equipment_rental_system.dto.userauth.UserAuthRequest;
import edu.miu.cs489.university_campus_equipment_rental_system.model.Role;
import edu.miu.cs489.university_campus_equipment_rental_system.model.User;
import edu.miu.cs489.university_campus_equipment_rental_system.repository.UserRepository;
import edu.miu.cs489.university_campus_equipment_rental_system.utils.service.JWTManagementUtilityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/user"})
public class UserAuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
        private JWTManagementUtilityService jwtManagementUtilityService;
    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    public UserAuthController(JWTManagementUtilityService jwtManagementUtilityService,
                              AuthenticationManager authenticationManager,UserRepository UserRepository) {
        this.jwtManagementUtilityService = jwtManagementUtilityService;
        this.authenticationManager = authenticationManager;
        this. userRepository = userRepository;
    }

    @PostMapping(value = {"/authenticate"})
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(),
                            userAuthRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            System.out.println("Invalid Username and/or Password!");
            throw ex;
        }
        // todo fetch all the user's info - firstName, lastName etc.
        return jwtManagementUtilityService.generateToken(userAuthRequest.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserAuthRequest userAuthRequest) {
        if (userRepository.existsByUsername(userAuthRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }


        User newUser = new User();
        newUser.setUsername(userAuthRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(userAuthRequest.getPassword()));
        List<Role> roles = new ArrayList<>();
        //Role role1 = new Role();
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully!");
    }
}
