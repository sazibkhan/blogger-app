package com.blogger.bloggerapp.dto.request;

import lombok.Data;

@Data
public class PostDTO {

    private String postTitle;
    private String postBody;
    private Long bookId;
}
