package com.example.demo.repository;

import com.example.demo.domain.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleImageService extends JpaRepository<ArticleImage, Long> {

}
