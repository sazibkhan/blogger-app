package com.blogger.bloggerapp.dto.request;

import lombok.Data;


@Data
public class CommentDTO {

    private String comment;
    private Long postId;


}
