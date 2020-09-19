package pro.bolshakov.geekbrains.lesson06.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.lesson06.domain.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAll() {
        return Arrays.asList(
                new Product(1L, "Product 1", 10.1),
                new Product(2L, "Product 2", 20.1),
                new Product(3L, "Product 3", 320.1)
        );
    }

    @Override
    public Product getById(Long id) {
        return new Product(id, "Temp product", 10.0);
    }

    @Override
    public Product save(Product product) {
        return new Product(2L, "Temp product", 10.0);
    }

    @Override
    public List<Product> getByPrice(double priceFrom, double priceTo) {
        return Arrays.asList(
                new Product(1L, "Product 1", 10.1),
                new Product(2L, "Product 2", 20.1),
                new Product(3L, "Product 3", 320.1)
        );
    }
}
