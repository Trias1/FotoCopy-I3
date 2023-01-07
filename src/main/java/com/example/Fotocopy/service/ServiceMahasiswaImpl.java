package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Dosen;
import com.example.Fotocopy.model.Kuliah;
import com.example.Fotocopy.model.Mahasiswa;
import com.example.Fotocopy.model.dto.MahasiswaDto;
import com.example.Fotocopy.repo.DosenRepo;
import com.example.Fotocopy.repo.MhsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServiceMahasiswaImpl implements MahasiswaService {

    @Autowired
    MhsRepo mhsRepo;

    @Autowired
    DosenRepo dosenRepo;


    @Override
    public Mahasiswa getMahasiswaId(Long idMahasiswa) {
        return mhsRepo.findById(idMahasiswa).get();
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return this.mhsRepo.findAll();
    }

    @Override
    public Mahasiswa saveMahasiswa(MahasiswaDto mhs) {
        Mahasiswa mhs1 = new Mahasiswa();
        BeanUtils.copyProperties(mhs, mhs1);
        Dosen dosen = dosenRepo.findById(mhs.getIdDosen()).get();
        mhs1.setDosen(dosen);
        return mhsRepo.save(mhs1);
    }

    @Override
    public void updateMahasiswa(Long idMahasiswa, MahasiswaDto mhs) {
        Mahasiswa mhs1 = mhsRepo.findById(idMahasiswa).get();
        BeanUtils.copyProperties(mhs,mhs1);
        BeanUtils.copyProperties(mhs,mhs1);
        mhs1.setNim(mhs.getNim());
        mhs1.setNamaMahasiswa(mhs.getNamaMahasiswa());
        Dosen dosen = dosenRepo.findById(mhs.getIdDosen()).get();
        mhs1.setDosen(dosen);
        mhsRepo.save(mhs1);
    }

    @Override
    public void deleteMahasiswa(Long idMahasiswa) {
        mhsRepo.deleteById(idMahasiswa);
    }
}
