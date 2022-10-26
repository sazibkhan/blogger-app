package com.blogger.bloggerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {

    private Long id;
    private String username;
    private String email;
    private String gender;


}
