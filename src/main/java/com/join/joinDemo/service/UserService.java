package com.join.joinDemo.service;

import com.join.joinDemo.Model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
     List<User> getAllUsers();
     User getUserById(Long id);
     String saveUser(User user);
     String deleteUser(User user);
     String deleteUserById(long id);
     String uploadImage(MultipartFile multipartFile);
     byte[] downloadImage(String path);
}
