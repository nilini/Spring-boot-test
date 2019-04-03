package com.springboottest.example.Controller;

import com.springboottest.example.Domain.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    /*
    * Spring Boot会将List集合转换为json
    * */
    @RequestMapping("/findBooks")
    public List<Book> findBooks(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1,"java", "wss", "java.jpg", 109.3, "kkkkkkkkk"));
        books.add(new Book(2,"php", "wss", "java.jpg", 109.3, "kkkkkkkkk"));
        books.add(new Book(3,"php", "wss", "java.jpg", 109.3, "kkkkkkkkk"));
        return books;
    }
}
