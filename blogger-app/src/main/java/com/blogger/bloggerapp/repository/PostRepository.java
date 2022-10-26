package com.blogger.bloggerapp.repository;

import com.blogger.bloggerapp.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {



}
