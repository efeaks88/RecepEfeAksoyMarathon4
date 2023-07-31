package com.efeak.repository;

import com.efeak.repository.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISehirRepository extends JpaRepository<Sehir,Long> {
}
