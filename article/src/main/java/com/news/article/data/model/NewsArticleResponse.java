package com.news.article.data.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NewsArticleResponse {

    private int totalArticles;
    private List<Article> articles;
}
