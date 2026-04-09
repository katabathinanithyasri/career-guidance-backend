package com.fsad.backend.repository;

import com.fsad.backend.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ LOGIN WITH ROLE
    	
    User findByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE counselor_id = ?1", nativeQuery = true)
    void deleteUsersByCounselorId(Long counselorId);
}