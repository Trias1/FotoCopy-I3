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
public class Barang {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;
    private String barangName;
    private String description;
    private Integer stoct;
    private Float price;
//    private Long idCategory;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    Date create_at;
    @UpdateTimestamp
    Date update_at;
}
