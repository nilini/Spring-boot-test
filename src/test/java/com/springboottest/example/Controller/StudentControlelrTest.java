package com.springboottest.example.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControlelrTest {

    // 注入Spring 容器
    @Autowired
    private WebApplicationContext wac;

    // MockMvc实现了对http请求的模拟
    private MockMvc mvc;

    @Before
    public void setupMockMvc(){
        // 初始化MockMvc对象
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /*
    * 新增学生测试用例
    * */
    @Test
    @Transactional
    public void addStudent() throws Exception {
        String json="{\"name\":\"sun2\",\"address\":\"huoguoshan\",\"age\":\"700\",\"sex\":\"男\"}";
        mvc.perform(MockMvcRequestBuilders.post("/student/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /*
    * 获取学生信息测试用例
    * */
    @Test
    public void qryStudent() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/student/get/20")
            .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("sun"))
                .andDo(MockMvcResultHandlers.print());
    }

}
