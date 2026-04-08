package com.fsad.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "counselors")
public class Counselor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String expertise;    // Specialization
    private String experience;
    private String availability;

    @OneToMany(mappedBy = "counselor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("counselor") // prevent infinite recursion
    private List<Session> sessions;

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) { this.expertise = expertise; }
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
    public List<Session> getSessions() { return sessions; }
    public void setSessions(List<Session> sessions) { this.sessions = sessions; }
}