package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Mahasiswa;
import com.example.Fotocopy.model.dto.MahasiswaDto;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;


    @GetMapping({"/getMhs/{idMahasiswa}"})
    public ResponseEntity<Mahasiswa> getMahasiswaId(@PathVariable Long idMahasiswa) {
        Mahasiswa mhs = mahasiswaService.getMahasiswaId(idMahasiswa);
        return ResponseEntity.ok(mhs);
    }
    @GetMapping("/getMhs")
    public ResponseEntity<List<Mahasiswa>> getAllMahasiswa() {

        List<Mahasiswa> productList = mahasiswaService.getAllMahasiswa();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/getMhs")
    public ResponseEntity<ResponseMessage> saveMahasiswa(@RequestBody MahasiswaDto mhs) {
        String data = "";
        String message = "";
        try {
            mahasiswaService.saveMahasiswa(mhs);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @PutMapping("/getMhs/{idMahasiswa}")
    public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable("idMahasiswa") Long idMahasiswa, @RequestBody MahasiswaDto mhs1) {

        mahasiswaService.updateMahasiswa(idMahasiswa, mhs1);
        return new ResponseEntity<>(mahasiswaService.getMahasiswaId(idMahasiswa), HttpStatus.OK);
    }

    @DeleteMapping({"/getMhs/{idMahasiswa}"})
    public ResponseEntity<Mahasiswa> deleteMahasiswa(@PathVariable("idMahasiswa") Long idMahasiswa) {
        mahasiswaService.deleteMahasiswa(idMahasiswa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
