package com.example.Fotocopy.repo;

import com.example.Fotocopy.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BarangRepository extends JpaRepository<Barang, Long> {
//    Optional<Barang> findByProducId(Long id);
}
