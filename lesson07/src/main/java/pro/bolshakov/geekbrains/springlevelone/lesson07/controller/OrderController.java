package pro.bolshakov.geekbrains.springlevelone.lesson07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Order;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Product;

import java.util.Arrays;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/1")
    @ResponseBody
    public Order getOrder(){
        return new Order(1L,
                Arrays.asList(
                        new Product(1L, "Cheese", 15.5),
                        new Product(2L, "Milk", 25.5)
                )
        );
    }
}
