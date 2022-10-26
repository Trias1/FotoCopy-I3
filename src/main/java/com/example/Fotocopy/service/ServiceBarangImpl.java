package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Barang;
import com.example.Fotocopy.model.Category;
import com.example.Fotocopy.repo.BarangRepository;
import com.example.Fotocopy.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ServiceBarangImpl implements BarangService{

    @Autowired
    BarangRepository barangRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Barang getBarangId(Long id) {
        return barangRepository.findById(id).get();
    }

    @Override
    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    @Override
    public Barang saveBarang(Barang barang) {
//        Barang barang1 = new Barang();
//        barang1.setBarangName(barang.getBarangName());
//        barang1.setDescription(barang.getDescription());
//        barang1.setStoct(barang.getStoct());
//        barang1.setPrice(barang.getPrice());
//        barang1.setIdCategory(barang.getIdCategory());
//        Category category = categoryRepository.findById(barang.getIdCategory()).get();
        return barangRepository.save(barang);
    }

    @Override
    public void updateBarang(Long id, Barang barang) {
        Barang barang1 = barangRepository.findById(id).get();
        barang1.setBarangName(barang.getBarangName());
        barang1.setDescription(barang.getDescription());
        barang1.setStoct(barang.getStoct());
        barang1.setPrice(barang.getPrice());
//        barang1.setIdCategory(barang.getIdCategory());
        barangRepository.save(barang1);
    }

    @Override
    public void delelteBarang(Long id) {
        barangRepository.deleteById(id);
    }
}
