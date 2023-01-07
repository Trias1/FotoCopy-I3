package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Dosen;
import com.example.Fotocopy.model.Matkul;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DosenController {
    @Autowired
    DosenService dosenService;

    @GetMapping({"/getDosen/{idDosen}"})
    public ResponseEntity<Dosen> getCategoryId(@PathVariable Long idDosen) {
        Dosen dosen = dosenService.getDosenId(idDosen);
        return ResponseEntity.ok(dosen);
    }
    @GetMapping("/getDosen")
    public ResponseEntity<List<Dosen>> getAllDosen() {

        List<Dosen> productList = dosenService.getAllDosen();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/getDosen")
    public ResponseEntity<ResponseMessage> saveDosen(@RequestBody Dosen dosen) {
        String data = "";
        String message = "";
        try {
            dosenService.saveDosen(dosen);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @PutMapping("/getDosen/{idDosen}")
    public ResponseEntity<Dosen> updateDosen(@PathVariable("idDosen") Long idDosen, @RequestBody Dosen dosen1) {

        dosenService.updateDosen(idDosen, dosen1);
        return new ResponseEntity<>(dosenService.getDosenId(idDosen), HttpStatus.OK);
    }

    @DeleteMapping({"/getDosen/{idDosen}"})
    public ResponseEntity<Matkul> deleteDosen(@PathVariable("idDosen") Long idDosen) {
        dosenService.deleteDosen(idDosen);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
