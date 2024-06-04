package com.news.article.service;

import com.news.article.data.model.NewsArticleResponse;
import com.news.article.feign.GNewsFeignClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleService {

    GNewsFeignClient gNewsFeignClient;
    Map<String, NewsArticleResponse> keyWordResponse = new HashMap<>();
    static final String API_KEY = "910a840c601b0aa3a5fe256f6ce724fa";

    public NewsArticleResponse getNewsArticle(int limit) {
        return gNewsFeignClient.getNewsArticle(API_KEY, "example", limit);
    }

    public NewsArticleResponse getNewsArticle(String keyword) {
        return keyWordResponse.computeIfAbsent(keyword, k -> gNewsFeignClient.getNewsArticle(API_KEY, k));
    }
}
