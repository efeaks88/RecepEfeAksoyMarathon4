package com.efeak.repository;

import com.efeak.repository.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IKullaniciRepository extends JpaRepository<Kullanici,Long> {
    Boolean existsByUsername(String username);
    Optional<Kullanici> findOptionalByUsernameAndPassword(String username, String password);
}
