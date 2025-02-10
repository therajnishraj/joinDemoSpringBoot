package com.join.joinDemo.serviceImpl;

import com.join.joinDemo.Model.User;
import com.join.joinDemo.repo.UserRepo;
import com.join.joinDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @Override
    public String saveUser(User user) {
        userRepo.save(user);
        return "User saved successfully..!";
    }

    @Override
    public String deleteUser(User user) {
        userRepo.delete(user);
        return "User deleted successfully..!";
    }
}
