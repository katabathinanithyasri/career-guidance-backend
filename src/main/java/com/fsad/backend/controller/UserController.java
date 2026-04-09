package com.fsad.backend.controller;

import com.fsad.backend.model.Counselor;
import com.fsad.backend.model.User;
import com.fsad.backend.repository.CounselorRepository;
import com.fsad.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepo;
    private final CounselorRepository counselorRepo;

    public UserController(UserRepository userRepo, CounselorRepository counselorRepo) {
        this.userRepo = userRepo;
        this.counselorRepo = counselorRepo;
    }

    // ✅ GET all users with counselors
    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll(); // FetchType.EAGER ensures counselor is included
    }
 // In UserController.java
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
    // ✅ ADD user with optional counselor
    @PostMapping
    public User addUser(@RequestBody User user) {
        if (user.getCounselor() != null && user.getCounselor().getId() != null) {
            Counselor c = counselorRepo.findById(user.getCounselor().getId())
                    .orElseThrow(() -> new RuntimeException("Counselor not found"));
            user.setCounselor(c);
        }

        // Auto-generate password if null or empty
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(generateRandomPassword(8)); // 8-char random password
        }

        return userRepo.save(user);
    }

    // Utility method to generate a simple random password
    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$!";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(idx));
        }
        return sb.toString();
    }
    // ✅ UPDATE user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User existing = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());

        if (user.getCounselor() != null && user.getCounselor().getId() != null) {
            Counselor c = counselorRepo.findById(user.getCounselor().getId())
                    .orElseThrow(() -> new RuntimeException("Counselor not found"));
            existing.setCounselor(c);
        } else {
            existing.setCounselor(null);
        }

        return userRepo.save(existing);
    }

    // ✅ DELETE user


 // ✅ DELETE user safely
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Remove counselor reference to avoid FK issues
        user.setCounselor(null);
        userRepo.delete(user);

        return ResponseEntity.noContent().build(); // 204 No Content
    }
    }
