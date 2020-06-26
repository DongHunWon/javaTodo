package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserDao userDao;

    // hash
    private static String bytesToHex(String password) {
        byte[] hash = password.getBytes();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setBlood(0);
        user.setSecondpassword("");
        if(userDao.findByEmail(user.getEmail()).isPresent()){
            return user;
        } else {
            user.setPassword(bytesToHex(user.getPassword()));
            return userDao.save(user);
        }
    }
}
