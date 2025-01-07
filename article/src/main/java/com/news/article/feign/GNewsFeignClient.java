package com.news.article.feign;

import com.news.article.data.model.NewsArticleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "news", url = "${news.service.url}")
public interface GNewsFeignClient {

    @GetMapping(value = "${news.article.service.search}")
    NewsArticleResponse getNewsArticle(@RequestParam("apikey") String apiKey, @RequestParam("q") String q, @RequestParam(value = "max") int max);
    @GetMapping(value = "${news.article.service.search}")
    NewsArticleResponse getNewsArticle(@RequestParam("apikey") String apiKey, @RequestParam("q") String q);

}
