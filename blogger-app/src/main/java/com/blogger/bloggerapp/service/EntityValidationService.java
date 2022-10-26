package com.blogger.bloggerapp.service;

import com.blogger.bloggerapp.entity.BookEntity;
import com.blogger.bloggerapp.entity.CommentEntity;
import com.blogger.bloggerapp.entity.PostEntity;
import com.blogger.bloggerapp.entity.UserEntity;
import com.blogger.bloggerapp.repository.BookRepository;
import com.blogger.bloggerapp.repository.CommentRepository;
import com.blogger.bloggerapp.repository.PostRepository;
import com.blogger.bloggerapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EntityValidationService {

    private final BookRepository bookRepository;
    private  final PostRepository postRepository ;
    private  final CommentRepository commentRepository ;
    private  final UserRepository userRepository;

    public UserEntity validateUser(Long id) {
        Objects.requireNonNull(id);
        return userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format(" not found with id [%s]", id)));
    }

    public BookEntity validateBook(Long id) {
        Objects.requireNonNull(id);
        return bookRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format(" not found with id [%s]", id)));
    }


    public PostEntity validatePost(Long id) {
        Objects.requireNonNull(id);
        return postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format(" not found with id [%s]", id)));
    }

    public CommentEntity validateComment(Long id) {
        Objects.requireNonNull(id);
        return commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format(" not found with id [%s]", id)));
    }


}
