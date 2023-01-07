package com.example.Fotocopy.model;

import com.example.Fotocopy.model.dto.MahasiswaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Peserta {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long idPeserta;

    @OneToOne
    @JoinColumn(name = "idKuliah")
    private Kuliah kuliah;

    @OneToOne
    @JoinColumn(name = "idMahasiswa")
    private Mahasiswa mahasiswa;

    private Float nilai;

    @CreationTimestamp
    @Column(updatable = false)
    Date create_at;
    @UpdateTimestamp
    Date update_at;
}
