package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Mahasiswa;
import com.example.Fotocopy.model.dto.MahasiswaDto;

import java.util.List;

public interface MahasiswaService {
    Mahasiswa getMahasiswaId(Long idMahasiswa);
    List<Mahasiswa> getAllMahasiswa();
    Mahasiswa saveMahasiswa(MahasiswaDto mhs);
    void updateMahasiswa(Long idMahasiswa, MahasiswaDto mhs);
    void deleteMahasiswa(Long idMahasiswa);
}
