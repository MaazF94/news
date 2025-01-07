package com.news.article.service;

import com.news.article.data.model.NewsArticleResponse;
import com.news.article.feign.GNewsFeignClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleService {

    GNewsFeignClient gNewsFeignClient;
    Map<String, NewsArticleResponse> keyWordResponse = new HashMap<>();
    String apiKey;

    public ArticleService(@Value("${api.key}") String apiKey, GNewsFeignClient gNewsFeignClient) {
        this.apiKey = apiKey;
        this.gNewsFeignClient = gNewsFeignClient;
    }

    public NewsArticleResponse getNewsArticle(int limit) {
        return gNewsFeignClient.getNewsArticle(apiKey, "example", limit);
    }

    public NewsArticleResponse getNewsArticle(String keyword) {
        return keyWordResponse.computeIfAbsent(keyword, k -> gNewsFeignClient.getNewsArticle(apiKey, k));
    }
}
