package com.java.skywebtz.repositories;

import com.java.skywebtz.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    AdminModel findByValue(Long value);

    boolean existsByValue(Long value);
}
