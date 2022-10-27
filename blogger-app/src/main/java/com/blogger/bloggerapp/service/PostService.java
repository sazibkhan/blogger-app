package com.blogger.bloggerapp.service;


import com.blogger.bloggerapp.dto.request.CommentDTO;
import com.blogger.bloggerapp.dto.request.PostDTO;
import com.blogger.bloggerapp.dto.response.CommentRest;
import com.blogger.bloggerapp.dto.response.PostRest;
import com.blogger.bloggerapp.entity.CommentEntity;
import com.blogger.bloggerapp.entity.PostEntity;
import com.blogger.bloggerapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final  EntityValidationService entityValidationService;


    public void createPost(PostDTO postDTO){
        var postEntity=new PostEntity();
        var bookEntity=entityValidationService.validateBook(postDTO.getBookId());
        BeanUtils.copyProperties(postDTO, postEntity);
        postEntity.setBookEntity(bookEntity);

        postRepository.save(postEntity);

    }
//    public PostRest getPostById(Long id) {
//
//        var postEntity = entityValidationService.validatePost(id);
//
//        var response = new PostRest();
//        BeanUtils.copyProperties(postEntity, response);
//        return response;
//    }
//
//    public void updatePost(Long id, PostDTO postDTO) {
//
//        var postEntity = entityValidationService.validatePost(id);
//        var bookEntity = entityValidationService.validateBook(postDTO.getBookId());
//
//        postEntity.setPostTitle(postDTO.getPostTitle());
//        postEntity.setPostBody(postDTO.getPostBody());
//        postEntity.setBookEntity(bookEntity);
//
//        postRepository.save(postEntity);
//    }
//
//    public void deletePostById(Long id) {
//
//        var postEntity = entityValidationService.validatePost(id);
//
//        postRepository.deleteById(postEntity.getId());
//
//    }


//    public List<PostRest> getPostList() {
//
//        return postRepository.findAll().stream()
//                .map(itm -> getPostRest(itm))
//                .sorted(Comparator.comparing(PostRest::getPostTitle))
//                .collect(Collectors.toList());
//    }
//
//
//    private PostRest getPostRest(PostEntity itm) {
//        var res = new PostRest();
//        BeanUtils.copyProperties(itm, res);
//        Optional.ofNullable(itm.getBookEntity())
//                .ifPresent(book -> {
//                    res.setBookId(book.getId());
//                });
//        return res;
//    }

}
