package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Matkul;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatkulController {
    @Autowired
    MatkulService MatkulService;

    @GetMapping({"/getMatkul/{idMatkul}"})
    public ResponseEntity<Matkul> getCategoryId(@PathVariable Long idMatkul) {
        Matkul matkul = MatkulService.getMatkulId(idMatkul);
        return ResponseEntity.ok(matkul);
    }

    @GetMapping("/getMatkul")
    public ResponseEntity<List<Matkul>> getAllMatkul() {

        List<Matkul> productList = MatkulService.getAllMatkul();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/getMatkul")
    public ResponseEntity<ResponseMessage> saveMatkul(@RequestBody Matkul matkul) {
        String data = "";
        String message = "";
        try {
            MatkulService.saveMatkul(matkul);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @PutMapping("/getMatkul/{idMatkul}")
    public ResponseEntity<Matkul> updateCategory(@PathVariable("idMatkul") Long idMatkul, @RequestBody Matkul matkul1) {

        MatkulService.updateMatkul(idMatkul, matkul1);
        return new ResponseEntity<>(MatkulService.getMatkulId(idMatkul), HttpStatus.OK);
    }

    @DeleteMapping({"/getMatkul/{idMatkul}"})
    public ResponseEntity<Matkul> deleteMatkul(@PathVariable("idMatkul") Long idMatkul) {
        MatkulService.deleteMatkul(idMatkul);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
