package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Kuliah;
import com.example.Fotocopy.model.dto.KuliahDto;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.KuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KuliahController {
    @Autowired
    KuliahService kuliahService;

    @GetMapping({"/getKuliah/{idKuliah}"})
    public ResponseEntity<Kuliah> getBarangId(@PathVariable Long idKuliah) {
        Kuliah kuliah = kuliahService.getBarangId(idKuliah);
        return ResponseEntity.ok(kuliah);
    }

    @GetMapping("/getKuliah")
    public ResponseEntity<List<Kuliah>> getAllBarang() {

        List<Kuliah> customersList = kuliahService.getAllBarang();

        return ResponseEntity.ok(customersList);
    }

    @PostMapping("/getKuliah")
    public ResponseEntity<ResponseMessage> saveBarang(@RequestBody KuliahDto kuliahDto) {
        String mess = "";
        String data = "";
        try {
            kuliahService.saveBarang(kuliahDto);
            mess = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mess, data));
        } catch (Exception e) {
            mess = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mess, data));
        }
    }

    @PutMapping("/getKuliah/{idKuliah}")
    public ResponseEntity<Kuliah> updateBarang(@PathVariable("idKuliah") Long idKuliah, @RequestBody KuliahDto barang) {
        kuliahService.updateBarang(idKuliah, barang);
        return new ResponseEntity<>(kuliahService.getBarangId(idKuliah), HttpStatus.OK);
    }

    @DeleteMapping({"/getKuliah/{idKuliah}"})
    public ResponseEntity<Kuliah> deleteBarang(@PathVariable("idKuliah") Long idKuliah) {
        kuliahService.delelteBarang(idKuliah);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
