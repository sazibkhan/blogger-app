package com.blogger.bloggerapp.service;

import com.blogger.bloggerapp.dto.request.UserDTO;
import com.blogger.bloggerapp.dto.response.UserRest;
import com.blogger.bloggerapp.entity.UserEntity;
import com.blogger.bloggerapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityValidationService entityValidationService;

    public void createUser(UserDTO userDTO) {

        var userEntity= new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);

        userRepository.save(userEntity);

    }

    public UserRest getUserById(long id){

        var userEntity=entityValidationService.validateUser(id);
        var respose=new UserRest();
        BeanUtils.copyProperties(userEntity,respose);

        return respose;

    }

    public void updateUser(Long id, UserDTO userDTO){
        var userEntity=entityValidationService.validateUser(id);
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setGender(userDTO.getGender());

        userRepository.save(userEntity);
    }


    public void deleteUserById(Long id){
        var userEntity=entityValidationService.validateUser(id);
        userRepository.deleteById(userEntity.getId());
    }


    public List<UserRest> getUserList() {

        return userRepository.findAll().stream()
                .map(itm -> {
                    var res = new UserRest();
                    BeanUtils.copyProperties(itm, res);
                    return res;
                }).collect(Collectors.toList());
    }



}
