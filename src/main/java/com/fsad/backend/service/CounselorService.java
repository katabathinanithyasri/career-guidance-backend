package com.fsad.backend.service;

import com.fsad.backend.model.Counselor;
import com.fsad.backend.repository.CounselorRepository;
import com.fsad.backend.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselorService {

    private final CounselorRepository counselorRepo;
    private final SessionRepository sessionRepo;

    // ✅ Constructor Injection (IMPORTANT)
    public CounselorService(CounselorRepository counselorRepo, SessionRepository sessionRepo) {
        this.counselorRepo = counselorRepo;
        this.sessionRepo = sessionRepo;
    }

    // ✅ GET ALL
    public List<Counselor> getAllCounselors() {
        return counselorRepo.findAll();
    }

    // ✅ ADD
    public Counselor addCounselor(Counselor counselor) {
        return counselorRepo.save(counselor);
    }

    // ✅ UPDATE
    public Counselor updateCounselor(Long id, Counselor counselor) {
        Counselor existing = counselorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Counselor not found"));

        existing.setName(counselor.getName());
        existing.setEmail(counselor.getEmail());
        existing.setExpertise(counselor.getExpertise());

        return counselorRepo.save(existing);
    }

    // ✅ DELETE (FIXED PROPERLY)
    public void deleteCounselor(Long id) {
        if (!counselorRepo.existsById(id)) {
            throw new RuntimeException("Counselor not found");
        }

        // 🔥 delete child records first
        sessionRepo.deleteSessionsByCounselorId(id);

        // 🔥 then delete parent
        counselorRepo.deleteById(id);
    }
}