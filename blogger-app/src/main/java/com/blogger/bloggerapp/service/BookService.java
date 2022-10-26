package com.blogger.bloggerapp.service;

import com.blogger.bloggerapp.dto.request.BookDTO;
import com.blogger.bloggerapp.dto.response.BookRest;
import com.blogger.bloggerapp.entity.BookEntity;
import com.blogger.bloggerapp.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final  EntityValidationService entityValidationService;

    public void createBook(BookDTO bookDTO){

        var bookEntity=new BookEntity();
        BeanUtils.copyProperties(bookDTO,bookEntity);

        bookRepository.save(bookEntity);
    }


    public BookRest getBookById(Long id){

        var bookEntity=entityValidationService.validateBook(id);

        var response=new BookRest();
        BeanUtils.copyProperties(bookEntity,response);

        return  response;
    }



        public void updateBook(Long id, BookDTO bookDTO){

        var bookEntity=entityValidationService.validateBook(id);

          bookEntity.setBookName(bookDTO.getBookName());
          bookEntity.setBookPrice(bookDTO.getBookPrice());
          bookEntity.setBookDescription(bookDTO.getBookDescription());

          bookRepository.save(bookEntity);
        }



        public void deleteBookById(Long id){
        var bookEntity=entityValidationService.validateBook(id);
            bookRepository.deleteById(bookEntity.getId());
        }


        public List<BookRest> getBookList(){
                return bookRepository.findAll().stream()
                    .map(itm->{
                        var res=new BookRest();
                        BeanUtils.copyProperties(itm,res);
                        return res;
                }).collect(Collectors.toList());
}




}
