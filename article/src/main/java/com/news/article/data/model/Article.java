package com.news.article.data.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Article {

    String title;
    String description;
    String content;
    String url;
    String image;
    Date publishedAt;
    Source source;

    @Data
    @Builder
    public static class Source {
        public String name;
        public String url;
    }
}
