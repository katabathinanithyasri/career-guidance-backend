// src/main/java/com/fsad/backend/model/Career.java
package com.fsad.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "careers")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String skills;
    private String salary;
    private String roadmap;
    private String demand;

    // Constructors
    public Career() {}

    public Career(String title, String description, String skills, String salary, String roadmap, String demand) {
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.salary = salary;
        this.roadmap = roadmap;
        this.demand = demand;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }

    public String getRoadmap() { return roadmap; }
    public void setRoadmap(String roadmap) { this.roadmap = roadmap; }

    public String getDemand() { return demand; }
    public void setDemand(String demand) { this.demand = demand; }
}