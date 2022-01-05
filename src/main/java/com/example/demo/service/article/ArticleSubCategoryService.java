package com.example.demo.service.article;

import com.example.demo.domain.ArticleSubCategory;
import com.example.demo.repository.ArticleSubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ArticleSubCategoryService {
    private final ArticleSubCategoryRepository articleSubCategoryRepository;

    public Optional<ArticleSubCategory> getArticleSubCategory(Long id) {
        return articleSubCategoryRepository.findById(id);
    }

    public List<ArticleSubCategory> getArticleSubCategorys() {
        return articleSubCategoryRepository.findAll();
    };

    public ArticleSubCategory saveArticleSubCategory(ArticleSubCategory articleSubCategory) {
        return articleSubCategoryRepository.save(articleSubCategory);
    };
}
