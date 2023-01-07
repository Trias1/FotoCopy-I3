package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Peserta;
import com.example.Fotocopy.model.dto.PesertaDto;

import java.util.List;

public interface PesertaService {
    Peserta getPesertaId(Long idPeserta);
    List<Peserta> getAllPeserta();
    Peserta savePeserta(PesertaDto pesertaDto);
    void updatePeserta(Long idPeserta, PesertaDto pesertaDto);
    void deletePeserta(Long idPeserta);
}
