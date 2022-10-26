package com.blogger.bloggerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRest{

    private Long id;
    private String postTitle;
    private String postBody;
    private Long bookId;

}
