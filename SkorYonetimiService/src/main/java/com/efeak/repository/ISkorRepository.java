package com.efeak.repository;

import com.efeak.repository.entity.Skor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkorRepository extends JpaRepository<Skor, Long> {
    Skor findByUsername(String username);
}
