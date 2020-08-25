package com.test.task.service;

import com.test.task.dto.entity.Article;
import com.test.task.dto.entity.ArticleSearchDto;
import com.test.task.dto.entity.Product;
import com.test.task.dto.entity.ProductSearchDto;
import com.test.task.repository.ArticleRepository;
import com.test.task.repository.ProductRepository;
import com.test.task.repository.SpecificationArticle;
import com.test.task.repository.SpecificationProduct;
import com.test.task.util.ErrorCode;
import com.test.task.util.MasterException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final ArticleRepository articleRepository;

    private final ProductRepository productRepository;

    public void addNewProduct(Product product) {
        if (product.getId() != null) {
            Optional<Product> productOptional = productRepository.findById(product.getId());
            if (productOptional.isPresent()) {
                throw new MasterException(ErrorCode.PRODUCT_IS_PRESENT);
            } else {
                productRepository.save(product);
            }
        } else {
            productRepository.save(product);
        }
    }

    public void updateProduct(Product product) {
        if (product.getId() != null) {
            Optional<Product> productOptional = productRepository.findById(product.getId());
            if (productOptional.isPresent()) {
                productRepository.save(product);
            } else {
                throw new MasterException(ErrorCode.PRODUCT_IS_PRESENT);
            }
        } else {
            throw new MasterException(ErrorCode.PRODUCT_IS_PRESENT);
        }
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new MasterException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    public Article getArticle(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new MasterException(ErrorCode.ARTICLE_NOT_FOUND));
    }

    public void addNewArticle(Article article) {
        if (article.getId() != null) {
            Optional<Article> articleOptional = articleRepository.findById(article.getId());
            if (articleOptional.isPresent()) {
                throw new MasterException(ErrorCode.ARTICLE_IS_PRESENT);
            } else {
                article.setCreated(LocalDateTime.now());
                articleRepository.save(article);
            }
        } else {
            article.setCreated(LocalDateTime.now());
            articleRepository.save(article);
        }
    }

    public void updateArticle(Article article) {
        if (article.getId() != null) {
            Optional<Article> articleOptional = articleRepository.findById(article.getId());
            if (articleOptional.isPresent()) {
                articleRepository.save(article);
            } else {
                throw new MasterException(ErrorCode.ARTICLE_IS_PRESENT);
            }
        } else {
            throw new MasterException(ErrorCode.ARTICLE_IS_PRESENT);
        }

    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new MasterException(ErrorCode.ARTICLE_NOT_FOUND));
        articleRepository.delete(article);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new MasterException(ErrorCode.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }

    public List<Product> searchProduct(ProductSearchDto dto) {
        if (dto.getDescription() != null && dto.getDescription().equals("")) {
            dto.setDescription(null);
        }
        if (dto.getName() != null && dto.getName().equals("")) {
            dto.setName(null);
        }
        if (dto.getPrice() != null && dto.getPrice().equals("")) {
            dto.setPrice(null);
        }
        Specification<Product> spec1 = SpecificationProduct.productId(dto.getId());
        Specification<Product> spec2 = SpecificationProduct.productName(dto.getName());
        Specification<Product> spec3 = SpecificationProduct.productDescription(dto.getDescription());
        Specification<Product> spec4 = SpecificationProduct.productPrice(dto.getPrice());

        Specification<Product> spec = Specification.where(spec1).and(spec2).and(spec3).and(spec4);
        return productRepository.findAll(spec);
    }

    public List<Article> searchArticle(ArticleSearchDto dto) {
        if (dto.getContent() != null && dto.getContent().equals("")) {
            dto.setContent(null);
        }
        if (dto.getName() != null && dto.getName().equals("")) {
            dto.setName(null);
        }

        Specification<Article> spec1 = SpecificationArticle.productId(dto.getProductId());
        Specification<Article> spec2 = SpecificationArticle.articleId(dto.getId());
        Specification<Article> spec3 = SpecificationArticle.articleName(dto.getName());
        Specification<Article> spec4 = SpecificationArticle.articleContent(dto.getContent());
        Specification<Article> spec5 = SpecificationArticle.articleCreated(dto.getFromDate(), dto.getToDate());

        Specification<Article> spec = Specification.where(spec1).and(spec2).and(spec3).and(spec4).and(spec5);
        return articleRepository.findAll(spec);
    }
}
