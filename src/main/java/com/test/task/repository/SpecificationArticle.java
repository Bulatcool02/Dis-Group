package com.test.task.repository;

import com.test.task.dto.entity.Article;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class SpecificationArticle {
    public static Specification<Article> articleId(Long id) {
        return (root, query, builder) ->
                id == null ?
                        builder.conjunction() :
                        builder.equal(root.get("id"), id);
    }

    public static Specification<Article> productId(Long productId) {
        return (root, query, builder) ->
                productId == null ?
                        builder.conjunction() :
                        builder.equal(root.get("productId"), productId);
    }

    public static Specification<Article> articleName(String name) {
        return (root, query, builder) ->
                name == null ?
                        builder.conjunction() :
                        builder.equal(root.get("name"), name);
    }

    public static Specification<Article> articleContent(String content) {
        return (root, query, builder) ->
                content == null ?
                        builder.conjunction() :
                        builder.equal(root.get("content"), content);
    }

    public static Specification<Article> articleCreated(LocalDateTime fromDate, LocalDateTime toDate) {
        return (root, query, builder) ->
                fromDate == null ?
                        builder.conjunction() :
                        builder.between(root.get("created"),fromDate, toDate);
    }
}
