package com.example.Fotocopy.repo;

import com.example.Fotocopy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
