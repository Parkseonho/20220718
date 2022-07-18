package com.mysite.sbb1.reply;

import com.mysite.sbb1.article.domain.Article;
import com.mysite.sbb1.reply.dao.ReplyRepository;
import com.mysite.sbb1.reply.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void create(Article article, String content){
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setArticle(article);
        this.replyRepository.save(reply);
    }


}
