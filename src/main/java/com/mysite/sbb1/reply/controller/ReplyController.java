package com.mysite.sbb1.reply.controller;

import com.mysite.sbb1.article.domain.Article;
import com.mysite.sbb1.article.service.ArticleService;
import com.mysite.sbb1.reply.ReplyForm;
import com.mysite.sbb1.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ArticleService articleService;
    private final ReplyService replyService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid ReplyForm replyForm, BindingResult bindingResult){
        Article article = this.articleService.getArticle(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("article", article);
            return "/article_detail";
        }

        this.replyService.create(article, replyForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }
}
