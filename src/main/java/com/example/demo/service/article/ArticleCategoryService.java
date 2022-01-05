package com.example.demo.service.article;

import com.example.demo.repository.ArticleCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.demo.domain.ArticleCategory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ArticleCategoryService {
    private final ArticleCategoryRepository articleCategoryRepository;

    public Optional<ArticleCategory> getArticleCategory(Long id) {
        return articleCategoryRepository.findById(id);
    }

    public List<ArticleCategory> getArticleCategorys() {
        return articleCategoryRepository.findAll();
    };

    public ArticleCategory saveArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryRepository.save(articleCategory);
    }
}
