package pro.bolshakov.geekbrains.springlevelone.lesson08.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
}
