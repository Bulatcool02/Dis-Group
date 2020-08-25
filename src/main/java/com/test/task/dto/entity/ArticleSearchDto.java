package com.test.task.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleSearchDto {
    private Long id;
    private Long productId;
    private String name;
    private String content;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
