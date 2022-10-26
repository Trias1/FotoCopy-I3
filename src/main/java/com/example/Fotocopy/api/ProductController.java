package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Barang;
import com.example.Fotocopy.model.Category;
import com.example.Fotocopy.model.dto.BarangDto;
import com.example.Fotocopy.model.dto.DefaultResponse;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.repo.BarangRepository;
import com.example.Fotocopy.repo.CategoryRepository;
import com.example.Fotocopy.service.BarangService;
import com.example.Fotocopy.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    BarangService barangService;

    @Autowired
    BarangRepository barangRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/getBarangs")
    public List<BarangDto> getListJenis() {
        List<BarangDto> list = new ArrayList<>();
        for (Barang m : barangRepository.findAll()) {
//            for (Category n : categoryRepository.findAll())
                list.add(convertEntitytoDto(m));
        }
        return list;
    }

    @PostMapping("/getBarangs")
    public DefaultResponse<BarangDto> saveCategory(@RequestBody BarangDto barangDto) {
        Barang barang = convertDtotoEntity(barangDto);
        DefaultResponse<BarangDto> df = new DefaultResponse<>();
        Optional<Barang> optionalBarang = barangRepository.findById(barangDto.getId());
        if (optionalBarang.isPresent()) {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Gagal Menyimpan, Kategori Telah Tersedia");
        } else {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Kategori Berhasil Disimpan");
            df.setData(convertEntitytoDto(barangRepository.save(barang)));
        }
        return df;
    }

    private BarangDto convertEntitytoDto(Barang m) {
        BarangDto dto = new BarangDto();
        BeanUtils.copyProperties(m,dto);
        dto.setIdCategory(m.getCategory().getIdCategory());
        dto.setBarangName(m.getCategory().getCategoryName());

        return dto;
    }

    private Barang convertDtotoEntity(BarangDto categoryDto) {
        Barang entity = new Barang();
        BeanUtils.copyProperties(categoryDto,entity);
        Category category = categoryRepository.findById(categoryDto.getIdCategory()).get();
        entity.setCategory(category);

        return entity;
    }

//    private BarangDto convertEntityToDtoJenis(Barang m) {
//        BarangDto barangDto = new BarangDto();
//        barangDto.se(m.getBarangName());
//        barangDto.setNamaCategory(m.getCategory().getCategoryName());
//        barangDto.setDescription(m.getDescription());
//        return barangDto;
//    }

    @GetMapping({"/getBarang/{id}"})
    public ResponseEntity<Barang> getBarangId(@PathVariable Long id) {
        Barang barang = barangService.getBarangId(id);
        return ResponseEntity.ok(barang);
    }

    @GetMapping("/getBarang")
    public ResponseEntity<List<Barang>> getAllBarang() {

        List<Barang> customersList = barangService.getAllBarang();

        return ResponseEntity.ok(customersList);
    }

    @PostMapping("/getBarang")
    public ResponseEntity<ResponseMessage> saveBarang(@RequestBody Barang barang) {
        String mess = "";
        String data = "";
        try {
            barangService.saveBarang(barang);
            mess = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mess, data));
        } catch (Exception e) {
            mess = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mess, data));
        }
    }

    @PutMapping("/getBarang/{id}")
    public ResponseEntity<Barang> updateBarang(@PathVariable("id") Long id, @RequestBody Barang barang) {
        barangService.updateBarang(id, barang);
        return new ResponseEntity<>(barangService.getBarangId(id), HttpStatus.OK);
    }

    @DeleteMapping({"/getBarang/{id}"})
    public ResponseEntity<Barang> deleteBarang(@PathVariable("id") Long id) {
        barangService.delelteBarang(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
