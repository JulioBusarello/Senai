package com.julio.app_cad_pro.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String category;
    private String supplier;

    @Transient
    private MultipartFile image;

    @Lob
    @Column(name = "imagem")
    private byte[] imageBytes;

    public void setImagem(MultipartFile image) {
        this.image = image;
        if (image != null && !image.isEmpty()) {
            try {
                this.imageBytes = image.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
