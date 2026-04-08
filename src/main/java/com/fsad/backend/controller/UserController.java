package com.fsad.backend.controller;

import com.fsad.backend.model.User;
import com.fsad.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }
}