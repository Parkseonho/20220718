package com.mysite.sbb1.reply;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReplyForm {
    @NotEmpty(message = "내용은 필수")
    private String content;
}
