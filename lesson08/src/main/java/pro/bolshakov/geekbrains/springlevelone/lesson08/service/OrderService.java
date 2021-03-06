package pro.bolshakov.geekbrains.springlevelone.lesson08.service;


import pro.bolshakov.geekbrains.springlevelone.lesson08.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto findById(Long id);

    List<OrderDto> findAll();

    OrderDto save(OrderDto dto);
}
