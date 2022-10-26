package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Barang;

import java.util.List;

public interface BarangService {
    Barang getBarangId(Long id);
    List<Barang> getAllBarang();
    Barang saveBarang(Barang barang);
    void updateBarang(Long id, Barang barang);
    void delelteBarang(Long id);
}
