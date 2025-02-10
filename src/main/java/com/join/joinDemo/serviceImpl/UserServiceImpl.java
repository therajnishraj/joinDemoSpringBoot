package com.join.joinDemo.serviceImpl;

import com.join.joinDemo.Model.User;
import com.join.joinDemo.repo.UserRepo;
import com.join.joinDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Override
    public String deleteUserById(long id) {
        userRepo.deleteById(id);
        return "User deleted successfully..!";
    }

    @Override
    public String uploadImage(MultipartFile multipartFile) {
        File file = new File("/home/rajnish/Desktop/testMultipart/" + multipartFile.getOriginalFilename());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(multipartFile.getBytes());
            return "image saved successfully";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] downloadImage(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            byte[] bytes = fileInputStream.readAllBytes();
            return bytes;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
