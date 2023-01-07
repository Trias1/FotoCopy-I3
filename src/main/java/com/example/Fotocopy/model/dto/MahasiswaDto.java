package com.example.Fotocopy.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MahasiswaDto {
    private Long nim;
    private String namaMahasiswa;
    private Long idDosen;
}
