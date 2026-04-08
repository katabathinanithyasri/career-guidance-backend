// src/main/java/com/fsad/backend/controller/CareerController.java
package com.fsad.backend.controller;

import com.fsad.backend.model.Career;
import com.fsad.backend.service.CareerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin(origins = "http://localhost:5173") // React dev server URL
public class CareerController {

    private final CareerService service;

    public CareerController(CareerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Career> getAll() {
        return service.getAllCareers();
    }

    @PostMapping
    public Career create(@RequestBody Career career) {
        return service.addCareer(career);
    }

    @PutMapping("/{id}")
    public Career update(@PathVariable Long id, @RequestBody Career career) {
        return service.updateCareer(id, career);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCareer(id);
    }
}