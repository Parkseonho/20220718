package com.mysite.sbb1.article.controller;

import com.mysite.sbb1.article.dao.ArticleRepository;
import com.mysite.sbb1.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return articleRepository.findAll();
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Article showDetail(@RequestParam int id, String name){
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @RequestMapping("/doModify")
    @ResponseBody
    public Article showModify(@RequestParam int id, String subject, String content) {
        Article article = articleRepository.findById(id).get();
        if(subject != null){
            article.setSubject(subject);
        }
        if(content != null){
            article.setContent(content);
        }
        article.setUpdateDate(LocalDateTime.now());
        articleRepository.save(article); //수정된 데이터 DB에 저장
        return article;
    }

}
