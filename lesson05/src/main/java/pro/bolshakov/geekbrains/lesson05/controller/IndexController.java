package pro.bolshakov.geekbrains.lesson05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.bolshakov.geekbrains.lesson05.domain.User;

import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "My message plus random UUID 1-> " + UUID.randomUUID());
        model.addAttribute("title", "Spring Level one");
        model.addAttribute("user", new User("Vasiliy"));
        return "index";
    }



}
