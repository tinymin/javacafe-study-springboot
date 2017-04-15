package com.keumnim.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by keumsunghyun on 2017. 4. 8..
 */
@Repository
public class ArticleRepository {

    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void add(Article article) {

         jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO ARTICLE(ID,TITLE,AUTHOR,BODY)";
        sql += "VALUES(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{
                article.getId(),
                article.getTitle(),
                article.getAuthor(),
                article.getBody()
        });
    }

    public Article get(Long id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM ARTICLE WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, i) -> {

            Article article = new Article();
            article.setId(rs.getLong("ID"));
            article.setTitle(rs.getString("TITLE"));
            article.setAuthor(rs.getString("AUTHOR"));
            article.setBody(rs.getString("BODY"));

            return article;
        });


    }
}
