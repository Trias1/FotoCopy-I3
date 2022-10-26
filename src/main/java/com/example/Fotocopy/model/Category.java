package com.example.Fotocopy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long idCategory;
    private String categoryName;

    @CreationTimestamp
    @Column(updatable = false)
    Date create_at;
    @UpdateTimestamp
    Date update_at;
}
