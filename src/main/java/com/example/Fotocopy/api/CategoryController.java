package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Category;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping({"/getCategory/{idCategory}"})
    public ResponseEntity<Category> getCategoryId(@PathVariable Long idCategory) {
        Category category = categoryService.getCategoryId(idCategory);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<Category>> getAllCategory() {

        List<Category> productList = categoryService.getAllCategory();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/getCategory")
    public ResponseEntity<ResponseMessage> saveCategory(@RequestBody Category category) {
        String data = "";
        String message = "";
        try {
            categoryService.saveCategory(category);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @PutMapping("/getCategory/{idCategory}")
    public ResponseEntity<Category> updateCategory(@PathVariable("idCategory") Long idCategory, @RequestBody Category category1) {

        categoryService.updateCategory(idCategory, category1);
        return new ResponseEntity<>(categoryService.getCategoryId(idCategory), HttpStatus.OK);
    }

    @DeleteMapping({"/getCategory/{idCategory}"})
    public ResponseEntity<Category> deleteCategory(@PathVariable("idCategory") Long idCategory) {
        categoryService.deleteCategory(idCategory);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
