package pro.bolshakov.geekbrains.springlevelone.lesson08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.User;
import pro.bolshakov.geekbrains.springlevelone.lesson08.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getList(Model model){
        model.addAttribute("users", userService.getAll());
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        User byId = userService.getById(id);
        model.addAttribute("user", byId == null ? new User() : byId);
        return "user";
    }

}
