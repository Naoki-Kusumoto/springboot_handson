package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "https://jsonplaceholder.typicode.com/todos/1";
    
    @GetMapping("/index")
    public String test(Model model){
        RandomValue user = restTemplate.getForObject(url, RandomValue.class);
        model.addAttribute("title", "Top Page");
        model.addAttribute("currentUser", user);
        model.addAttribute("url", url);
        
        return "index";
    }

    public static class RandomValue {
        public String userId;
        public String id;
        public String title;
        public String completed;
    }
}