package com.blogger.bloggerapp.controller;

import com.blogger.bloggerapp.common.ResponseFactory;
import com.blogger.bloggerapp.dto.RestResponse;
import com.blogger.bloggerapp.dto.request.UserDTO;
import com.blogger.bloggerapp.dto.response.UserRest;
import com.blogger.bloggerapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public RestResponse createUser(@RequestBody UserDTO userDTO){
        System.out.println("Successfull.....Controller!");
        userService.createUser(userDTO);
        return ResponseFactory.saveSuccess();
    }
    @GetMapping
    public RestResponse getUserList(){
        return  ResponseFactory.responseData(userService.getUserList());
    }

    @GetMapping("{id}")
    public UserRest getUserById(@PathVariable long id){
        return  userService.getUserById(id);
    }


    @PutMapping("{id}")
    public RestResponse updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        userService.updateUser(id,userDTO);
        return  ResponseFactory.updateSuccess();
    }


    @DeleteMapping("{id}")
    public RestResponse deleteUser(@PathVariable Long id) {

        userService.deleteUserById(id);
        return ResponseFactory.deleteSuccess();
    }

}
