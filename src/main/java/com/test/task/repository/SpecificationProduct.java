package com.test.task.repository;

import com.test.task.dto.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationProduct {
    public static Specification<Product> productId(Long id) {
        return (root, query, builder) ->
                id == null ?
                        builder.conjunction() :
                        builder.equal(root.get("id"), id);
    }


    public static Specification<Product> productName(String name) {
        return (root, query, builder) ->
                name == null ?
                        builder.conjunction() :
                        builder.equal(root.get("name"), name);
    }

    public static Specification<Product> productDescription(String description) {
        return (root, query, builder) ->
                description == null ?
                        builder.conjunction() :
                        builder.equal(root.get("description"), description);
    }
    public static Specification<Product> productPrice(String price) {
        return (root, query, builder) ->
                price == null ?
                        builder.conjunction() :
                        builder.equal(root.get("price"), price);
    }
}
