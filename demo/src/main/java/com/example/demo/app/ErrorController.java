package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorController {
    @ExceptionHandler(NullPointerException.class)
    public String NullPointerExceptionHandler(){
        System.out.println("NullPointerException occured");
        return "error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String IlligalArgumentExceptionHandler(){
        System.out.println("IllegalArgumentException occured");
        return "error";
    }

    @ExceptionHandler(Throwable.class)
    public String ThrowableHandler(){
        System.out.println("Exception occured");
        return "error";
    }
    
}