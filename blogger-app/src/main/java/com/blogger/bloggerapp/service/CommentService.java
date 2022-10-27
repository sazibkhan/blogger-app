package com.blogger.bloggerapp.service;

import com.blogger.bloggerapp.dto.request.CommentDTO;
import com.blogger.bloggerapp.dto.response.CommentRest;
import com.blogger.bloggerapp.entity.CommentEntity;
import com.blogger.bloggerapp.repository.CommentRepository;
import com.blogger.bloggerapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CommentService {

    private  final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final  EntityValidationService  entityValidationService;


    public void createComment(CommentDTO commentDTO){

        var commentEntity=new CommentEntity();
        var postEntity=entityValidationService.validatePost(commentDTO.getPostId());
        BeanUtils.copyProperties(commentDTO, commentEntity);
        commentEntity.setPostEntity(postEntity);

        commentRepository.save(commentEntity);
    }

//    public CommentRest getCommentById(Long id) {
//
//        var commentEntity = entityValidationService.validateComment(id);
//
//        var response = new CommentRest();
//        BeanUtils.copyProperties(commentEntity, response);
//        return response;
//    }
//
//    public void updateComment(Long id, CommentDTO commentDTO) {
//
//        var commentEntity = entityValidationService.validateComment(id);
//        var postEntity = entityValidationService.validatePost(commentDTO.getPostId());
//
//        commentEntity.setId(commentDTO.getPostId());
//        commentEntity.setComment(commentDTO.getComment());
//        commentEntity.setPostEntity(postEntity);
//        commentRepository.save(commentEntity);
//    }
//
//    public void deleteCommitById(Long id) {
//
//        var commentEntity = entityValidationService.validateComment(id);
//
//        commentRepository.deleteById(commentEntity.getId());
//
//    }
//
//
//
//    public List<CommentRest> getCommentList() {
//
//        return commentRepository.findAll().stream()
//                .map(itm -> getCommentRest(itm))
//                .sorted(Comparator.comparing(CommentRest::getComment))
//                .collect(Collectors.toList());
//    }
//
//
//    private CommentRest getCommentRest(CommentEntity itm) {
//        var res = new CommentRest();
//        BeanUtils.copyProperties(itm, res);
//        Optional.ofNullable(itm.getPostEntity())
//                .ifPresent(comment -> {
//                    res.setPostId(comment.getId());
//                });
//        return res;
//    }





}
