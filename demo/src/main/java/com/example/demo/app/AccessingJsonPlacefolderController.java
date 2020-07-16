package com.example.demo.app;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccessingJsonPlacefolderController {

private final RestTemplate restTemplate = new RestTemplate();

    // 外部サービスの URL 
    // JsonpraceFolder
    private final String url = "https://jsonplaceholder.typicode.com/todos/1";

    // 外部サービスの JSON を、そのまま（JSON のまま）返却。
    @RequestMapping(value="/json/exchange")
        public ResponseEntity<String> exchange() {
        return restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    // 外部サービスの JSON を、一度オブジェクトにしてから返却。
    @RequestMapping(value="/json/get-object")
        public RandomValue getObject() {
        return restTemplate.getForObject(url, RandomValue.class);
    }


    public static class RandomValue {
        public String userId;
        public String id;
        public String title;
        public String completed;
    }

}