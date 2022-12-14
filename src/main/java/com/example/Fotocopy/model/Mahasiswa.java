package com.example.Fotocopy.model;

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
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long idMahasiswa;
    private Long nim;
    private String namaMahasiswa;

    @OneToOne
    @JoinColumn(name = "idDosen")
    private Dosen dosen;

    @CreationTimestamp
    @Column(updatable = false)
    Date create_at;
    @UpdateTimestamp
    Date update_at;
}
