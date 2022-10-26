package com.blogger.bloggerapp.controller;

import com.blogger.bloggerapp.common.ResponseFactory;
import com.blogger.bloggerapp.dto.RestResponse;
import com.blogger.bloggerapp.dto.request.BookDTO;
import com.blogger.bloggerapp.dto.response.BookRest;
import com.blogger.bloggerapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {

    private  final BookService bookService;

    @PostMapping
    public RestResponse createBook(@RequestBody BookDTO bookDTO){

        bookService.createBook(bookDTO);
        return ResponseFactory.saveSuccess();
    }
    @GetMapping
    public RestResponse getBookLest(){
        return ResponseFactory.responseData(bookService.getBookList());
    }


    @GetMapping("{id}")
    public BookRest getBookById(@PathVariable Long id){
        return  bookService.getBookById(id);
    }


    @PutMapping("{id}")
    public RestResponse updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        bookService.updateBook(id,bookDTO);
        return  ResponseFactory.updateSuccess();
    }


    @DeleteMapping("{id}")
    public RestResponse deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseFactory.deleteSuccess();
    }



}
