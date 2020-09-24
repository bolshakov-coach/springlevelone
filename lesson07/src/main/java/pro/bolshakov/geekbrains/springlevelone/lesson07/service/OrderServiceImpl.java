package pro.bolshakov.geekbrains.springlevelone.lesson07.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springlevelone.lesson07.dao.OrderDao;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Order;
import pro.bolshakov.geekbrains.springlevelone.lesson07.dto.OrderDto;
import pro.bolshakov.geekbrains.springlevelone.lesson07.mapper.OrderMapper;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper mapper = OrderMapper.MAPPER;

    private final OrderDao dao;

    public OrderServiceImpl(OrderDao dao) {
        this.dao = dao;
    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.fromOrder(dao.getOne(id));
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.fromOrderList(dao.findAll());
    }

    @Override
    public OrderDto save(OrderDto dto) {
        Order entity = mapper.toOrder(dto);
        Order savedEntity = dao.save(entity);
        return mapper.fromOrder(savedEntity);
    }
}
