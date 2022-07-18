package com.mysite.sbb1.article.dao;

import com.mysite.sbb1.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
