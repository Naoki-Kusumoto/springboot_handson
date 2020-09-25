package com.example.demo.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(){
        System.out.println("NullPointerException occured");
        return "error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentExceptionHandler(){
        System.out.println("IllegalArgumentException occured");
        return "error";
    }

    @ExceptionHandler(Throwable.class)
    public String ThrowableHandler(){
        System.out.println("Exception occured");
        return "error";
    }

    @RequestMapping(value = "/err", method = RequestMethod.GET)
    public String errorpage() throws Exception {
        throw new Exception();
    }
}
