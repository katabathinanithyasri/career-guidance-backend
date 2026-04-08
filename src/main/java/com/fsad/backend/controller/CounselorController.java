package com.fsad.backend.controller;

import com.fsad.backend.model.Counselor;
import com.fsad.backend.service.CounselorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counselors")
@CrossOrigin(origins = "*")
public class CounselorController {

    private final CounselorService service;

    public CounselorController(CounselorService service) {
        this.service = service;
    }

    // ✅ GET ALL
    @GetMapping
    public List<Counselor> getAll() {
        return service.getAllCounselors();
    }

    // ✅ ADD
    @PostMapping
    public Counselor add(@RequestBody Counselor c) {
        return service.addCounselor(c);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Counselor update(@PathVariable Long id, @RequestBody Counselor c) {
        return service.updateCounselor(id, c);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCounselor(id);
    }
}