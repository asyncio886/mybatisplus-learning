package com.controller;

import com.mappers.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestInsert {
    @Value("#{userMapper}")
    UserMapper userMapper;
    @GetMapping("/insert")
    public ResponseEntity<String> testInsert(){
        User user = new User();
        user.setId((long)3);
        user.setName("丁真");
        user.setPassword("1234567890");
        userMapper.insert(user);
        return ResponseEntity.ok("ok");
    }
}
