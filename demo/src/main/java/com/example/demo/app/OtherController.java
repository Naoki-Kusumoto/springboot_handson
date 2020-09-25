package com.example.demo.app;

import com.example.demo.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class OtherController {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String url = "https://jsonplaceholder.typicode.com/users/1";
    
    @GetMapping("/other")
    public String todo(Model model){
        User user = restTemplate.getForObject(url, User.class);
        model.addAttribute("title", "Other Page");
        model.addAttribute("UserInfo", user);
        model.addAttribute("url", url);
        
        return "other";
    }
}
