package com.keumnim.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by keumsunghyun on 2017. 4. 8..
 */

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repository;

    public Article createArticle(ArticleCreateRequest request) {

        Article article = new Article(
                request.getId(), request.getTitle(), request.getAuthor(), request.getBody()
        );

        repository.add(article);

        return article;

    }

    public Article getArticle(long articleId) {


        return repository.get(articleId);
    }
}
