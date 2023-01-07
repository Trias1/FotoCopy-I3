package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Kuliah;
import com.example.Fotocopy.model.Mahasiswa;
import com.example.Fotocopy.model.Peserta;
import com.example.Fotocopy.model.dto.PesertaDto;
import com.example.Fotocopy.repo.KuliahRepository;
import com.example.Fotocopy.repo.MhsRepo;
import com.example.Fotocopy.repo.PesertaRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServicePesertaImpl implements PesertaService {

    @Autowired
    PesertaRepo pesertaRepo;

    @Autowired
    MhsRepo mhsRepo;

    @Autowired
    KuliahRepository kuliahRepository;


    @Override
    public Peserta getPesertaId(Long idPeserta) {
        return pesertaRepo.findById(idPeserta).get();
    }

    @Override
    public List<Peserta> getAllPeserta() {
        return this.pesertaRepo.findAll();
    }

    @Override
    public Peserta savePeserta(PesertaDto pesertaDto) {
        Peserta peserta = new Peserta();
        BeanUtils.copyProperties(pesertaDto, peserta);
        Mahasiswa mahasiswa = mhsRepo.findById(pesertaDto.getIdMahasiswa()).get();
        peserta.setMahasiswa(mahasiswa);
        Kuliah kuliah = kuliahRepository.findById(pesertaDto.getIdKuliah()).get();
        peserta.setKuliah(kuliah);
        return pesertaRepo.save(peserta);
    }

    @Override
    public void updatePeserta(Long idPeserta, PesertaDto pesertaDto) {
        Peserta peserta = pesertaRepo.findById(idPeserta).get();
        BeanUtils.copyProperties(pesertaDto, peserta);
        BeanUtils.copyProperties(pesertaDto, peserta);
        peserta.setNilai(pesertaDto.getNilai());
        Mahasiswa mahasiswa = mhsRepo.findById(pesertaDto.getIdMahasiswa()).get();
        peserta.setMahasiswa(mahasiswa);
        Kuliah kuliah = kuliahRepository.findById(pesertaDto.getIdKuliah()).get();
        peserta.setKuliah(kuliah);
        pesertaRepo.save(peserta);
    }

    @Override
    public void deletePeserta(Long idPeserta) {
        mhsRepo.deleteById(idPeserta);
    }
}
