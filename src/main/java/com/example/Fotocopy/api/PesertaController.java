package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Peserta;
import com.example.Fotocopy.model.dto.PesertaDto;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PesertaController {

    @Autowired
    PesertaService pesertaService;

    @GetMapping({"/getPeserta/{idPeserta}"})
    public ResponseEntity<Peserta> getPesertaId(@PathVariable Long idPeserta) {
        Peserta peserta = pesertaService.getPesertaId(idPeserta);
        return ResponseEntity.ok(peserta);
    }
    @GetMapping("/getPeserta")
    public ResponseEntity<List<Peserta>> getAllMahasiswa() {

        List<Peserta> productList = pesertaService.getAllPeserta();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/getPeserta")
    public ResponseEntity<ResponseMessage> saveMahasiswa(@RequestBody PesertaDto pesertaDto) {
        String data = "";
        String message = "";
        try {
            pesertaService.savePeserta(pesertaDto);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @PutMapping("/getPeserta/{idPeserta}")
    public ResponseEntity<Peserta> updatePeserta(@PathVariable("idPeserta") Long idPeserta, @RequestBody PesertaDto pesertaDto) {

        pesertaService.updatePeserta(idPeserta, pesertaDto);
        return new ResponseEntity<>(pesertaService.getPesertaId(idPeserta), HttpStatus.OK);
    }

    @DeleteMapping({"/getPeserta/{idPeserta}"})
    public ResponseEntity<Peserta> deletePeserta(@PathVariable("idPeserta") Long idPeserta) {
        pesertaService.deletePeserta(idPeserta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
