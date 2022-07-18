package com.mysite.sbb1.article.controller;

import com.mysite.sbb1.article.ArticleForm;
import com.mysite.sbb1.article.domain.Article;
import com.mysite.sbb1.article.service.ArticleService;
import com.mysite.sbb1.reply.ReplyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")

public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public String showQuestions(Model model) {
        List<Article> articlesList = articleService.getList();
        model.addAttribute("articles",articlesList);
        return "article";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id, ReplyForm replyForm){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm){
        return "article_form";
    }
    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article_form";
        }

        this.articleService.create(articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list";
    }

}
