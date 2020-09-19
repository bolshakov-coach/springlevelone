package pro.bolshakov.geekbrains.lesson06.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    @GetMapping("/**")
    @ResponseBody
    public String helloWorld() {
        return "Hello, it is my Spring Boot App";
    }
}
