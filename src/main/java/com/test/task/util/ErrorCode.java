package com.test.task.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DEFAULT_ERROR_CODE("Произошла непредвиденная ошибка", HttpStatus.BAD_REQUEST),
    PRODUCT_IS_PRESENT("Продукт уже существует", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND("Продукт не найден", HttpStatus.BAD_REQUEST),
    ARTICLE_IS_PRESENT("Статья уже существует", HttpStatus.BAD_REQUEST),
    ARTICLE_NOT_FOUND("Статья не найдена", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_BE_NULL("Продукт не может быть пустым", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

}
