package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@AutoConfigureMockMvc
@SpringBootTest
public class HelloWorldTest {
    
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Testing hello world")
    @Test
    public void helloworldTest() throws Exception{
        //given
        //when
        ResultActions response = mockMvc.perform(get("/example"));

        //then
        response.andDo(print())
            .andExpect(status().isOk());
    }

}
