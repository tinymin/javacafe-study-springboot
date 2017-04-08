package com.keumnim.article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by keumsunghyun on 2017. 4. 8..
 */

@SpringBootTest

@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    public void 게시물_만들기_테스트() {

        //given : 테스트할때 필요한 정보들
        ArticleCreateRequest request = new ArticleCreateRequest(1L, "제목", "작가", "본문");

        //when : 테스트 코드 실행
        Article article = articleService.createArticle(request);

        //then : 테스트 결과 검증
        assertThat(article.getId(), is(1L));
        assertThat(article.getAuthor(), is("작가"));
        assertThat(article.getTitle(), is("제목"));
        assertThat(article.getBody(), is("본문"));
        assertThat(article.getCreated(), is(notNullValue()));

    }


    @Test
    public void 게시물_읽기_테스트() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(1L, "제목", "작가", "본문");
        articleService.createArticle(request);

        //when
        Article article = articleService.getArticle(1L);

        //then : 테스트 결과 검증
        assertThat(article.getId(), is(1L));
        assertThat(article.getAuthor(), is("작가"));
        assertThat(article.getTitle(), is("제목"));
        assertThat(article.getBody(), is("본문"));
        assertThat(article.getCreated(), is(notNullValue()));
    }
}