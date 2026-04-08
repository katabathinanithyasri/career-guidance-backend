package com.fsad.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String mode;
    private String status;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private Counselor counselor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // User who booked session

    // Getters & Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Counselor getCounselor() { return counselor; }
    public void setCounselor(Counselor counselor) { this.counselor = counselor; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}