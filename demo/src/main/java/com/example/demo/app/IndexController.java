package com.example.demo.app;

import com.example.demo.entity.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String url = "https://jsonplaceholder.typicode.com/todos/1";
    
    @GetMapping("/index")
    public String test(Model model){
        Todo user = restTemplate.getForObject(url, Todo.class);
        model.addAttribute("title", "Top Page");
        model.addAttribute("currentUser", user);
        model.addAttribute("url", url);
        
        return "index";
    }

}