package com.news.article.helpers;

import com.news.article.data.model.Article;
import com.news.article.data.model.NewsArticleResponse;

import java.util.Date;
import java.util.List;

public class NewsArticleHelper {

    public static NewsArticleResponse buildNewsArticleResponse() {
        return NewsArticleResponse.builder()
                .totalArticles(1)
                .articles(List.of(buildArticle()))
                .build();
    }

    private static Article buildArticle() {
        return Article.builder()
                .title("Hello World")
                .image("www.helloworld.com")
                .url("www.helloworld.com")
                .description("Hello World description")
                .publishedAt(new Date())
                .content("content")
                .source(buildArticleSource())
                .build();
    }

    private static Article.Source buildArticleSource() {
        return Article.Source.builder()
                .name("Name")
                .url("Url")
                .build();
    }
}
