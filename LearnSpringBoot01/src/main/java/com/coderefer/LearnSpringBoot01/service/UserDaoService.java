package com.coderefer.LearnSpringBoot01.service;

import com.coderefer.LearnSpringBoot01.entity.User;
import com.coderefer.LearnSpringBoot01.utils.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int usersCount = 3;
    Supplier<UserNotFoundException> userNotFound = () -> new UserNotFoundException("user not found");

    static {
        users.add(new User(1, "Vamsi", new Date()));
        users.add(new User(2, "Krishna", new Date()));
        users.add(new User(3, "T", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(userNotFound);
    }

    public void deleteById(int id) {
        User user = users.stream().filter(u -> u.getId() == id).findAny().orElseThrow(userNotFound);
        users.remove(user);
    }

}
