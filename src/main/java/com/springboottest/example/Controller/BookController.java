package com.springboottest.example.Controller;

import com.springboottest.example.Domain.Book;
import com.springboottest.example.Domain.User;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @RequestMapping("/register")
    public String register(HttpServletRequest request,
                           @ModelAttribute User user,
                           Model model) throws IOException {
        // 接收参数 username
        System.out.println("username = " + user.getName());
        if(!user.getHeadPortrail().isEmpty()){
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);

            String filename = user.getHeadPortrail().getOriginalFilename();
            File filepath = new File(path, filename);

            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }

            user.getHeadPortrail().transferTo(new File(path + File.separator + filename));

            System.out.println(user);
            return "userInfo";
        }else{
            return "error";
        }
    }

//    @RequestMapping("/download")
//    public ResponseEntity<byte[]> download(HttpServletRequest request,
//                                           @RequestParam("filename") String filename,
//                                           @RequestHeader("User-Agent") String userAgent,
//                                           Model model) throws UnsupportedEncodingException {
//        // 下载文件路径
//        String path = request.getServletContext().getRealPath("/upload/");
//        // 构建File
//        File file = new File(path + File.separator + filename);
//
//        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
//        // 内容长度
//        builder.contentLength(file.length());
//        // application/octet-stream
//        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
//        // 对文件名进行解码
//        filename = URLEncoder.encode(filename,"UTF-8");
//        // 设置实际的响应文件名，告诉浏览器文件要用于“下载”和保存
//        // 不同的浏览器，处理方式不同，
//        if(userAgent.indexOf("MSIE") > 0){
//            //
//            builder.header("Content-Disposition", "attachment; filename=" + filename);
//        }else{
//            builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
//        }
////        return builder.body(FileUtils.r);
//
//    }









}
