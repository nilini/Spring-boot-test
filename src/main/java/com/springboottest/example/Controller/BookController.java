package com.springboottest.example.Controller;

import com.springboottest.example.Domain.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    // 上传文件会自动绑定到MultipartFile中
    @PostMapping(value="/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws IOException {
        // 接收参数description
        System.out.println("description = " + description);
        if(!file.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);

            // 上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);

            // 判断路径是否存在，如果不存在就创建一个
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            // 将文件保存到一个目标文件中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        }else{
            return "error";
        }
    }
}
