package com.join.joinDemo.controller;

import com.join.joinDemo.Model.User;
import com.join.joinDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        String msg = userService.saveUser(user);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);

    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        String msg = userService.deleteUser(user);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") long id){
        String msg = userService.deleteUserById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @PostMapping("/uploadImg")
    public ResponseEntity<String> uploadImage(@RequestParam("imgfile")  MultipartFile multipartFile){
        String msg = userService.uploadImage(multipartFile);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @GetMapping("/downloadImg")
    public ResponseEntity<byte[]> downloadImg(@RequestParam("imgpath") String path){
        byte[] bytes = userService.downloadImage(path);
        return new ResponseEntity<>(bytes,HttpStatus.OK);

    }
    @GetMapping("/downloadImgInBase64")
    public ResponseEntity<String> downloadImgInBase64(@RequestParam("imgpath") String path){
        byte[] bytes = userService.downloadImage(path);
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return new ResponseEntity<>(base64,HttpStatus.OK);

    }
}
