package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Dosen;

import java.util.List;

public interface DosenService {
    Dosen getDosenId(Long idDosen);
    List<Dosen> getAllDosen();
    Dosen saveDosen(Dosen dosen);
    void updateDosen(Long idDosen, Dosen dosen);
    void deleteDosen(Long idDosen);
}
