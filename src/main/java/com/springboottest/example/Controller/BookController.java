package com.springboottest.example.Controller;

import com.springboottest.example.Domain.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    /*
    * Spring Boot默认使用JackSon解析json
    * */
    @RequestMapping("/findBook")
    public Book findBook(@RequestBody Book book){
        System.out.println(book);
        book.setAuthor("wss");
        book.setImage("AA.JPG");
        book.setPrice(55.09);
        book.setRemark("不错的书");
        return book;
    }
}
