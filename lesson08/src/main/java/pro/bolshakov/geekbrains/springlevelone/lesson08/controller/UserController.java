package pro.bolshakov.geekbrains.springlevelone.lesson08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.User;
import pro.bolshakov.geekbrains.springlevelone.lesson08.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getList(Model model,
                          @RequestParam(required = false) String username,
                          @RequestParam(required = false) String password){
        List<User> userList = new ArrayList<>();

        if(username != null){
            boolean auth = userService.auth(username, password);
            if(auth){
                userList = userService.getAll();
                System.out.println("You are authenticated");
            }
        }
        if(userList.isEmpty()){
            System.out.println("You are not authenticated");
        }

        model.addAttribute("users", userList);
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        User byId = userService.getById(id);
        model.addAttribute("user", byId == null ? new User() : byId);
        return "user";
    }

}
