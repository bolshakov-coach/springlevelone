package pro.bolshakov.geekbrains.lesson2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.bolshakov.geekbrains.lesson2.domain.Product;
import pro.bolshakov.geekbrains.lesson2.service.ProductServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(Model model,@PathVariable("id") Long id){
        Product byId = productService.getById(id);
        model.addAttribute("product",
                byId == null ? new Product(): byId);
        return "product";
    }

    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    @ResponseBody
    public String apiPrice(@PathVariable Long id){
        Product byId = productService.getById(id);
        return String.valueOf(byId == null ? null : byId.getPrice());
    }


}
