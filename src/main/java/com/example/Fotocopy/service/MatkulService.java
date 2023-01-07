package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Matkul;

import java.util.List;

public interface MatkulService {
    Matkul getMatkulId(Long idMatkul);
    List<Matkul> getAllMatkul();
    Matkul saveMatkul(Matkul matkul);
    void updateMatkul(Long idMatkul, Matkul matkul);
    void deleteMatkul(Long idMatkul);
}
