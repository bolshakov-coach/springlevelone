package pro.bolshakov.geekbrains.springlevelone.lesson08.service;

import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    boolean auth(String name, String password);

    List<User> getAll();
}
