package com.blogger.bloggerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class
BookRest {

    private Long id;
    private String bookName;
    private String bookDescription;
    private Integer bookPrice;
}
