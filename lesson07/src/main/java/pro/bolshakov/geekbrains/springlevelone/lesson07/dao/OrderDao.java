package pro.bolshakov.geekbrains.springlevelone.lesson07.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Order;

public interface OrderDao extends JpaRepository<Order, Long> {
}
