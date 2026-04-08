package com.fsad.backend.service;


import com.fsad.backend.model.Career;
import com.fsad.backend.repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    private final CareerRepository repo;

    public CareerService(CareerRepository repo) {
        this.repo = repo;
    }

    public List<Career> getAllCareers() {
        return repo.findAll();
    }

    public Career addCareer(Career career) {
        return repo.save(career);
    }

    public Career updateCareer(Long id, Career career) {
        Career existing = repo.findById(id).orElseThrow();
        existing.setTitle(career.getTitle());
        existing.setDescription(career.getDescription());
        existing.setSkills(career.getSkills());
        existing.setSalary(career.getSalary());
        existing.setRoadmap(career.getRoadmap());
        existing.setDemand(career.getDemand());
        return repo.save(existing);
    }

    public void deleteCareer(Long id) {
        repo.deleteById(id);
    }
}