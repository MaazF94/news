package com.news.article.feign;

import com.news.article.data.model.NewsArticleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "news", url = "https://gnews.io/api/v4")
public interface GNewsFeignClient {

    @GetMapping(value = "/search")
    NewsArticleResponse getNewsArticle(@RequestParam("apikey") String apiKey, @RequestParam("q") String q, @RequestParam(value = "max") int max);
    @GetMapping(value = "/search")
    NewsArticleResponse getNewsArticle(@RequestParam("apikey") String apiKey, @RequestParam("q") String q);

}
