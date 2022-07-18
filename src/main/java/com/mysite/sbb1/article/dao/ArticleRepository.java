package com.mysite.sbb1.article.dao;

import com.mysite.sbb1.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    boolean existsBySubject(String subject);


    List<Article> findBySubject(String subject);

    boolean existsByContent(String content);

    List<Article> findByContent(String content);

    boolean existsBySubjectAndContent(String subject, String content);

    List<Article> findBySubjectAndContent(String subject, String content);
}
