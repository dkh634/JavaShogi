package com.example.JavaShogi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello, JSON!");
        map.put("timestamp", System.currentTimeMillis());
        return map;  // Spring Bootが自動でJSONに変換して返す
    }
}

