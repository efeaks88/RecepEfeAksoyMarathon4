package com.efeak.repository;

import com.efeak.repository.entity.Tahmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITahminRepository extends JpaRepository<Tahmin,Long> {
}
