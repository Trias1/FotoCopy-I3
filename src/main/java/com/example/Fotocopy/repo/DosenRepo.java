package com.example.Fotocopy.repo;

import com.example.Fotocopy.model.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DosenRepo extends JpaRepository<Dosen, Long> {
    @Override
    Optional<Dosen> findById(Long id);
}
