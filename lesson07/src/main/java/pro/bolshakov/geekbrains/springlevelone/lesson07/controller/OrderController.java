package pro.bolshakov.geekbrains.springlevelone.lesson07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.bolshakov.geekbrains.springlevelone.lesson07.dao.OrderDao;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Order;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Product;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderDao orderDao;

    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping("/1")
    @ResponseBody
    public Order getOrder(){
        List<Order> all = orderDao.findAll();
        return all.isEmpty() ? null : all.get(0);
    }
}
