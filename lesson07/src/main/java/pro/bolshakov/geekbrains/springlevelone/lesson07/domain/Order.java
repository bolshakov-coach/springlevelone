package pro.bolshakov.geekbrains.springlevelone.lesson07.domain;

import java.util.List;

public class Order {

    private Long id;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
