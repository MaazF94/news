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

    public NewsArticleResponse getNewsArticle(int limit) {
        return gNewsFeignClient.getNewsArticle("910a840c601b0aa3a5fe256f6ce724fa", "example", limit);
    }

    public NewsArticleResponse getNewsArticle(String keyword) {
        return keyWordResponse.computeIfAbsent(keyword, k -> gNewsFeignClient.getNewsArticle("910a840c601b0aa3a5fe256f6ce724fa", k));
    }
}
