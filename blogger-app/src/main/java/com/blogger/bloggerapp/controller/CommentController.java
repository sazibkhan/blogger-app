package com.blogger.bloggerapp.controller;

import com.blogger.bloggerapp.common.ResponseFactory;
import com.blogger.bloggerapp.dto.RestResponse;
import com.blogger.bloggerapp.dto.request.CommentDTO;
import com.blogger.bloggerapp.dto.response.CommentRest;
import com.blogger.bloggerapp.dto.response.PostRest;
import com.blogger.bloggerapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/comments")
@AllArgsConstructor
public class CommentController {

    private  final CommentService commentService;


    @PostMapping
    public RestResponse createComment(@RequestBody CommentDTO commentDTO){
        commentService.createComment(commentDTO);
        return  ResponseFactory.saveSuccess();
    }


//    @GetMapping("{id}")
//    public CommentRest getCommentById(@PathVariable Long id) {
//
//        return commentService.getCommentById(id);
//    }
//
//    @PutMapping("{id}")
//    public void updateCommentById(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
//
//        commentService.updateComment(id, commentDTO);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteCommentById(@PathVariable Long id) {
//
//        commentService.deleteCommitById(id);
//    }
//
//
//    @GetMapping
//    public RestResponse getCommentList() {
//        return ResponseFactory.responseData(commentService.getCommentList());
//    }

}
