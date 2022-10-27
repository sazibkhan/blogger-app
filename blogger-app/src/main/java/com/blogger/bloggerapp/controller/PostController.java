package com.blogger.bloggerapp.controller;

import com.blogger.bloggerapp.common.ResponseFactory;
import com.blogger.bloggerapp.dto.RestResponse;
import com.blogger.bloggerapp.dto.request.CommentDTO;
import com.blogger.bloggerapp.dto.request.PostDTO;
import com.blogger.bloggerapp.dto.response.CommentRest;
import com.blogger.bloggerapp.dto.response.PostRest;
import com.blogger.bloggerapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public RestResponse createPost(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
        return ResponseFactory.saveSuccess();
    }

    @GetMapping
    public RestResponse getPostList() {
        return ResponseFactory.responseData(postService.getPostList());
    }


    @GetMapping("{id}")
    public PostRest getPostById(@PathVariable Long id) {

        return postService.getPostById(id);
    }
//
//    @PutMapping("{id}")
//    public void updatePostById(@PathVariable Long id, @RequestBody PostDTO postDTO ) {
//
//        postService.updatePost(id, postDTO);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteCommentById(@PathVariable Long id) {
//
//        postService.deletePostById(id);
//    }
//


}
