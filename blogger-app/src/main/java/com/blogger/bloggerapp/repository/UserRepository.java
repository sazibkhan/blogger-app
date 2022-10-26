package com.blogger.bloggerapp.repository;

import com.blogger.bloggerapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
