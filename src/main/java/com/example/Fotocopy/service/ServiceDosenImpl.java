package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Dosen;
import com.example.Fotocopy.repo.DosenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServiceDosenImpl implements DosenService {

    @Autowired
    DosenRepo dosenRepo;

    @Override
    public Dosen getDosenId(Long idDosen) {
        return dosenRepo.findById(idDosen).get();
    }

    @Override
    public List<Dosen> getAllDosen() {
        return this.dosenRepo.findAll();
    }

    @Override
    public Dosen saveDosen(Dosen dosen) {
        return dosenRepo.save(dosen);
    }

    @Override
    public void updateDosen(Long idDosen, Dosen dosen) {
        Dosen dosen1 = dosenRepo.findById(idDosen).get();
        dosen1.setNip(dosen.getNip());
        dosen1.setNamaDosen(dosen.getNamaDosen());
        dosenRepo.save(dosen1);
    }

    @Override
    public void deleteDosen(Long idDosen) {
        dosenRepo.deleteById(idDosen);
    }
}
