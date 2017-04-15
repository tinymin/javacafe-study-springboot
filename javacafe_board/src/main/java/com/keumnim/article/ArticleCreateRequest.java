package com.keumnim.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by keumsunghyun on 2017. 4. 8..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateRequest {

    private Long id;
    private String title;
    private String author;
    private String body;

}
