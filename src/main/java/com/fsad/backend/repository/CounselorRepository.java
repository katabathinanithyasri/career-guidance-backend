package com.fsad.backend.repository;

import com.fsad.backend.model.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
}