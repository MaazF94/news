package com.news.article.service;

import com.news.article.data.model.NewsArticleResponse;
import com.news.article.feign.GNewsFeignClient;
import com.news.article.helpers.NewsArticleHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    GNewsFeignClient gNewsFeignClient;
    String apiKey = "";
    ArticleService articleService;

    @BeforeEach
    public void setup() {
        this.articleService = new ArticleService(apiKey, gNewsFeignClient);
    }

    @Test
    public void getNewsArticleByLimit() {
        when(gNewsFeignClient.getNewsArticle(anyString(), anyString(), anyInt())).thenReturn(NewsArticleHelper.buildNewsArticleResponse());
        NewsArticleResponse newsArticleResponse = articleService.getNewsArticle(1);
        assertNotNull(newsArticleResponse);
        assertEquals(1, newsArticleResponse.getTotalArticles());
        assertEquals(1, newsArticleResponse.getArticles().size());
    }

    @Test
    public void getNewsArticleByKeyword() {
        String keyword = "Hello";
        when(gNewsFeignClient.getNewsArticle(anyString(), eq(keyword))).thenReturn(NewsArticleHelper.buildNewsArticleResponse());
        NewsArticleResponse newsArticleResponse = articleService.getNewsArticle(keyword);
        assertNotNull(newsArticleResponse);
        assertTrue(newsArticleResponse.getArticles().stream().allMatch(k -> k.getTitle().contains("Hello")));

        // Gets from Cache
        NewsArticleResponse newsArticleResponseDup = articleService.getNewsArticle(keyword);
        assertNotNull(newsArticleResponseDup);
        assertTrue(newsArticleResponseDup.getArticles().stream().allMatch(k -> k.getTitle().contains("Hello")));
    }

}