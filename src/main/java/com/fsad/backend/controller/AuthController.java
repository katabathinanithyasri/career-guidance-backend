package com.fsad.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fsad.backend.model.User;
import com.fsad.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ REGISTER (default USER)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        // 🔥 Always set USER role by default
        user.setRole("USER");

        User savedUser = repo.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ LOGIN WITH ROLE
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        // Step 1: Check email
        User existingUser = repo.findByEmail(user.getEmail());
        if (existingUser == null) {
            return ResponseEntity.status(404).body("User not found. Please register first.");
        }

        // Step 2: Role mismatch
        if (!existingUser.getRole().equalsIgnoreCase(user.getRole())) {
            return ResponseEntity.status(403).body(
                "You are not registered as " + user.getRole() +
                ". Please login as " + existingUser.getRole()
            );
        }

        // Step 3: Password check
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Incorrect password.");
        }

        // ✅ Optional: avoid returning null counselor details
        if (existingUser.getCounselor() == null) {
            existingUser.setCounselor(null);
        }

        return ResponseEntity.ok(existingUser);
    }
}