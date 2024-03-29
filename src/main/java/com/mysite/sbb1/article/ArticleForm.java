package com.mysite.sbb1.article;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목 입력 必")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용 입력 必")
    private String content;
}
