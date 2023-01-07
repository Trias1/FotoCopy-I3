package com.example.Fotocopy.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PesertaDto {
    private Long idMahasiswa;
    private Long idKuliah;
    private Float nilai;
}
