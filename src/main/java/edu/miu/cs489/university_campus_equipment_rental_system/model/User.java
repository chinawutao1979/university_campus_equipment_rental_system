package edu.miu.cs489.university_campus_equipment_rental_system.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private UserProfile userProfile;

    // Relationships with other entities
    @OneToOne(mappedBy = "user")
    private ERDStaff erdStaff;

    @OneToOne(mappedBy = "user")
    private Faculty faculty;

    @OneToOne(mappedBy = "user")
    private GraduateStudent graduateStudent;

    @OneToOne(mappedBy = "user")
    private Student student;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public UserProfile getUserProfile() {
//         return userProfile;
//    }
//
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }

    public ERDStaff getErdStaff() {
        return erdStaff;
    }

    public void setErdStaff(ERDStaff erdStaff) {
        this.erdStaff = erdStaff;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
