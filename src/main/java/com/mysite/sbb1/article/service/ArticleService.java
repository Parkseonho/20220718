package com.mysite.sbb1.article.service;

import com.mysite.sbb1.article.dao.ArticleRepository;
import com.mysite.sbb1.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        return article.get();

    }

    public void create(String subject, String content) {
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }

}
