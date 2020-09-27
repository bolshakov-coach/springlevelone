package pro.bolshakov.geekbrains.springlevelone.lesson08.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springlevelone.lesson08.dao.UserDao;
import pro.bolshakov.geekbrains.springlevelone.lesson08.domain.User;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public boolean auth(String name, String password) {
        User user = userDao.findFirstByName(name);
        if(user == null){
            return false;
        }
        return Objects.equals(password, user.getPassword());
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
