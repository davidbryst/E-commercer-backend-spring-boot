package com.example.demo.api;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleCategory;
import com.example.demo.domain.ArticleSubCategory;
import com.example.demo.service.article.ArticleCategoryService;
import com.example.demo.service.article.ArticleService;
import com.example.demo.service.article.ArticleSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/service")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleCategoryService articleCategoryService;
    public final ArticleSubCategoryService articleSubCategoryService;

    // article
    @GetMapping("/article/single/{ArticleId}")
    public ResponseEntity<Optional<Article>> getArticle(@PathVariable("ArticleId") Long id) {
        return ResponseEntity.ok().body(articleService.getArticle(id));
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping("/article/all")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok().body(articleService.getArticles());
    }

    // article category
    @GetMapping("/category/single/{ArticleCategoryId}")
    public Optional<ArticleCategory> getArticleCategory(@PathVariable("ArticleCategoryId") Long id) {
        return articleCategoryService.getArticleCategory(id);
    }

    @GetMapping("/category/all")
    public ResponseEntity<List<ArticleCategory>> getArticleCategorys() {
        return ResponseEntity.ok().body(articleCategoryService.getArticleCategorys());
    }

    //article sub category
    @GetMapping("/subcategory/single/{ArticleSubCategoryId}")
    public ResponseEntity<ArticleSubCategory> getArticleSubCategory(@PathVariable("ArticleSubCategoryId") Long id) {
        return ResponseEntity.ok().body(articleSubCategoryService.getArticleSubCategory(id).get());
    }

    @GetMapping("/subcategory/all")
    public ResponseEntity<List<ArticleSubCategory>> getArticleSubCategorys() {
        return ResponseEntity.ok().body(articleSubCategoryService.getArticleSubCategorys());
    }
}
