package pro.bolshakov.geekbrains.springlevelone.lesson07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/1")
    @ResponseBody
    public Product getProduct(){
        return new Product(1L, "Cheese", 15.5);
    }

}
