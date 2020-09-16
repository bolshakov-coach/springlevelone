package pro.bolshakov.geekbrains.lesson05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pro.bolshakov.geekbrains.lesson05.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User("Ivan", "ivanov@email.ru", 30));
        userList.add(new User("Petr", "petrov@email.ru", 60));
        userList.add(new User("Alex", "romanov@email.ru", -200));
    }

    @ModelAttribute("users")
    public List<User> populateUsers(){
        return userList;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "My message plus random UUID 1-> " + UUID.randomUUID());
        model.addAttribute("title", "Spring Level one");
        model.addAttribute("user", new User("Vasiliy"));
        return "index";
    }


    @GetMapping("/users")
    public String userList(Model model){
        return "userList";
    }




}
