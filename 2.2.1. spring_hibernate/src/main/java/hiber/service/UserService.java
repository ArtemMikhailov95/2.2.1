package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    default User getUser(Car car) {
        return new User();
    }

    List<User> listUsers();
}