package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Dosen;
import com.example.Fotocopy.model.Kuliah;
import com.example.Fotocopy.model.Matkul;
import com.example.Fotocopy.model.dto.KuliahDto;
import com.example.Fotocopy.repo.KuliahRepository;
import com.example.Fotocopy.repo.DosenRepo;
import com.example.Fotocopy.repo.MatkulRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServiceKuliahImpl implements KuliahService {

    @Autowired
    KuliahRepository kuliahRepository;

    @Autowired
    MatkulRepository matkulRepository;

    @Autowired
    DosenRepo dosenRepo;

    @Override
    public Kuliah getBarangId(Long idKuliah) {
        return kuliahRepository.findById(idKuliah).get();
    }

    @Override
    public List<Kuliah> getAllBarang() {
        return kuliahRepository.findAll();
    }

    @Override
    public Kuliah saveBarang(KuliahDto kuliahDto) {
        Kuliah barang1 = new Kuliah();
        BeanUtils.copyProperties(kuliahDto,barang1);
        Matkul category = matkulRepository.findById(kuliahDto.getIdMatkul()).get();
        barang1.setMatkul(category);
        Dosen ds = dosenRepo.findById(kuliahDto.getIdDosen()).get();
        barang1.setDosen(ds);
        return kuliahRepository.save(barang1);
    }

    @Override
    public void updateBarang(Long idKuliah, KuliahDto kuliahDto) {
        Kuliah barang1 = kuliahRepository.findById(idKuliah).get();
        BeanUtils.copyProperties(kuliahDto,barang1);
        barang1.setAkademik(kuliahDto.getAkademik());
        barang1.setJam(kuliahDto.getJam());
        barang1.setRuang(kuliahDto.getRuang());
        barang1.setSemester(kuliahDto.getSemester());
        Matkul category = matkulRepository.findById(kuliahDto.getIdMatkul()).get();
        barang1.setMatkul(category);
        Dosen ds = dosenRepo.findById(kuliahDto.getIdDosen()).get();
        barang1.setDosen(ds);
        kuliahRepository.save(barang1);
    }

    @Override
    public void delelteBarang(Long idKuliah) {
        kuliahRepository.deleteById(idKuliah);
    }
}