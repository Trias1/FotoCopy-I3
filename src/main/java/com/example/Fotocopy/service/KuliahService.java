package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Kuliah;
import com.example.Fotocopy.model.dto.KuliahDto;

import java.util.List;

public interface KuliahService {
    Kuliah getBarangId(Long idKuliah);
    List<Kuliah> getAllBarang();
    Kuliah saveBarang(KuliahDto kuliahDto);
    void updateBarang(Long idKuliah, KuliahDto kuliahDto);
    void delelteBarang(Long idKuliah);
}
