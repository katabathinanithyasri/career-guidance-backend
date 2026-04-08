// src/main/java/com/fsad/backend/repository/CareerRepository.java
package com.fsad.backend.repository;

import com.fsad.backend.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}