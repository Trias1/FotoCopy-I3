package com.example.Fotocopy.model.dto;

import lombok.*;

@Data
@Getter
@Setter
public class KuliahDto {
    private String akademik;
    private String ruang;
    private Integer jam;
    private Integer semester;
    private String namaDosen;
    private String Matakuliah;
    private Long idMatkul;
    private Long idDosen;
}
