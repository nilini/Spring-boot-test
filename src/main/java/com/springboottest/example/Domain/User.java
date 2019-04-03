package com.springboottest.example.Domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private MultipartFile headPortrail;

    public String getName() {
        return name;
    }

    public MultipartFile getHeadPortrail() {
        return headPortrail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadPortrail(MultipartFile headPortrail) {
        this.headPortrail = headPortrail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", headPortrail=" + headPortrail +
                '}';
    }
}
