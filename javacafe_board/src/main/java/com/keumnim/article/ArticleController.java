package com.keumnim.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by keumsunghyun on 2017. 4. 15..
 */

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    ArticleService service;


    @GetMapping(value = "/article/{articleId}")
    public String getArticle(Model model ,@PathVariable Long articleId){

        Article article = service.getArticle(articleId);
        log.info("articlearticlearticle로그"+article);
        model.addAttribute("article",article);

        return "article";

    }


    @PostMapping("/article")
    public String createArticle(@ModelAttribute ArticleCreateRequest request){
        service.createArticle(request);

        return "redirect:/article/" + request.getId();

    }


    @RequestMapping("/article/create")
    public String getArticle(){

        return "createArticle";

    }

}
