package com.example.Fotocopy.model.dto;

import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class BarangDto {
    private Long id;
    private String barangName;
    private String categoryName;
    private String description;
    private Long idCategory;
}
