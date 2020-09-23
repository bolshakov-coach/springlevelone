package pro.bolshakov.geekbrains.springlevelone.lesson07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.bolshakov.geekbrains.springlevelone.lesson07.dao.ProductDao;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/1")
    @ResponseBody
    public Product getProduct(){
        List<Product> all = productDao.findAll();
        return all.isEmpty() ? null : all.get(0);
    }

}
