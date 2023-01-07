package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Matkul;
import com.example.Fotocopy.repo.MatkulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ServiceMatkulImpl implements MatkulService {
    @Autowired
    MatkulRepository MatkulRepository;


    @Override
    public Matkul getMatkulId(Long idMatkul) {
        return MatkulRepository.findById(idMatkul).get();
    }

    @Override
    public List<Matkul> getAllMatkul() {
        return this.MatkulRepository.findAll();
    }

    @Override
    public Matkul saveMatkul(Matkul matkul) {
        return MatkulRepository.save(matkul);
    }

    @Override
    public void updateMatkul(Long idMatkul, Matkul matkul) {
        Matkul matkul1 = MatkulRepository.findById(idMatkul).get();
        matkul1.setMatakuliah(matkul.getMatakuliah());
        MatkulRepository.save(matkul1);
    }

    @Override
    public void deleteMatkul(Long idMatkul) {
        MatkulRepository.deleteById(idMatkul);
    }
}
