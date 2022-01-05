package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    private String description;
    private double price;
    private int quantity;

    @OneToOne(fetch = FetchType.EAGER)
    private ArticleImage articleImage;

    @ManyToOne(fetch = FetchType.EAGER)
    private ArticleSubCategory articleSubCategory;

    private Long createdAt;
    private Long updatedAt;
}
