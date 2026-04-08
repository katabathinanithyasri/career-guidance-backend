package com.fsad.backend.repository;

import com.fsad.backend.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sessions WHERE counselor_id = ?1", nativeQuery = true)
    void deleteSessionsByCounselorId(Long counselorId);
}