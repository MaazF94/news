package com.news.article.controller;

import com.news.article.data.model.NewsArticleResponse;
import com.news.article.helpers.NewsArticleHelper;
import com.news.article.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleControllerTest {

    private ArticleController articleController;
    @Mock
    private ArticleService articleService;

    @BeforeEach
    public void setup() {
        this.articleController = new ArticleController(articleService);
    }

    @Test
    void getNewsArticleByLimit() {
        when(articleService.getNewsArticle(1)).thenReturn(NewsArticleHelper.buildNewsArticleResponse());
        NewsArticleResponse response = articleController.newsArticles(1).getBody();
        assertNotNull(response);
        assertEquals(1, response.getTotalArticles());
        assertEquals(1, response.getArticles().size());
    }

    @Test
    void getNewsArticleByKeyword() {
        when(articleService.getNewsArticle("Hello")).thenReturn(NewsArticleHelper.buildNewsArticleResponse());
        NewsArticleResponse response = articleController.newsArticles("Hello").getBody();
        assertNotNull(response);
        assertTrue(response.getArticles().stream().allMatch(k -> k.getTitle().contains("Hello")));
    }
}