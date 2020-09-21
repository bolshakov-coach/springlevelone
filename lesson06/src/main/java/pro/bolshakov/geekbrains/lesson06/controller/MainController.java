package pro.bolshakov.geekbrains.lesson06.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String helloWorld() {
        return "index";
    }

    @GetMapping("/main")
    public String helloWorld2() {
        return "index";
    }
}
