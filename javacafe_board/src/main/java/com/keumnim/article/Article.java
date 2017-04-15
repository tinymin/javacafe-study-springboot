package com.keumnim.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created by keumsunghyun on 2017. 4. 8..
 */
@Getter
@Setter
public class Article {

    private Long id;
    private String title;
    private String author;
    private String body;

    public Article() {
    }

    public Article(Long id, String title, String author, String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
    }

}
