package com.example.Fotocopy.repo;

import com.example.Fotocopy.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MhsRepo extends JpaRepository<Mahasiswa, Long> {
}
