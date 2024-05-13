package com.news.article.controller;

import com.news.article.data.model.NewsArticleResponse;
import com.news.article.service.ArticleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news/admin")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleController {

    ArticleService articleService;

    @GetMapping("/articles/limit/{numOfArticles}")
    public ResponseEntity<NewsArticleResponse> newsArticles(@PathVariable int numOfArticles) {
        NewsArticleResponse results = articleService.getNewsArticle(numOfArticles);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping("/articles/search/{keyword}")
    public ResponseEntity<NewsArticleResponse> newsArticles(@PathVariable String keyword) {
        NewsArticleResponse results = articleService.getNewsArticle(keyword);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

}
