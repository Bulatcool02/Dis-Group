package com.test.task.controller;

import com.test.task.dto.entity.Article;
import com.test.task.dto.entity.ArticleSearchDto;
import com.test.task.dto.entity.Product;
import com.test.task.dto.entity.ProductSearchDto;
import com.test.task.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    /////////продукты//////////

    /**
     * Получение списка продуктов
     *
     * @return список
     */
    @GetMapping("/products")
    public List<Product> getProducts() {
        return mainService.getProducts();
    }

    /**
     * Поиск продуктов
     *
     * @param productSearchDto параметры поиска
     * @return список
     */
    @PostMapping("/products")
    public List<Product> searchProducts(@RequestBody ProductSearchDto productSearchDto) {
        return mainService.searchProduct(productSearchDto);
    }

    /**
     * добавление нового продукта
     *
     * @param product Продукт
     */
    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        mainService.addNewProduct(product);
    }

    /**
     * обновление сущетсующего продукта
     *
     * @param product продукт
     */
    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product) {
        mainService.updateProduct(product);
    }

    /**
     * получение одного продукта по id
     *
     * @param id идентификатор продукта
     * @return продукт
     */
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return mainService.getProduct(id);
    }

    /**
     * удаление продукта
     *
     * @param id идентификатор продукта
     */
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        mainService.deleteProduct(id);
    }

    /////////статьи//////////

    /**
     * Получение статьи по его id
     *
     * @param id идентификатор статьи
     * @return статья
     */
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable(name = "id") Long id) {
        return mainService.getArticle(id);
    }

    /**
     * получения списка статей
     *
     * @return список
     */
    @GetMapping("/articles")
    public List<Article> getArticles() {
        return mainService.getArticles();
    }

    /**
     * поиск статей
     *
     * @param articleSearchDto параметры поиска
     * @return список
     */
    @PostMapping("/articles")
    public List<Article> searchArticles(@RequestBody ArticleSearchDto articleSearchDto) {
        return mainService.searchArticle(articleSearchDto);
    }

    /**
     * добавление новой статьи
     *
     * @param article статья
     */
    @PostMapping("/article")
    public void addArticle(@RequestBody Article article) {
        mainService.addNewArticle(article);
    }

    /**
     * обновление сущетсвующей статьи
     *
     * @param article статья
     */
    @PutMapping("/article")
    public void updateArticle(@RequestBody Article article) {
        mainService.updateArticle(article);
    }

    /**
     * удаление статьи
     *
     * @param id идентификатор статьи
     */
    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable(name = "id") Long id) {
        mainService.deleteArticle(id);
    }
}
