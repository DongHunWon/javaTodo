package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

        user.setPassword(bytesToHex(user.getPassword()));
        return userDao.save(user);
    }

//    @PostMapping("/secondpassword")
//    public User secondpassword(@RequestBody User user) {
//        User original = userDao.findByEmail(user.getEmail()).get();
//        user.setPassword(original.getPassword());
//        user.setEmail(original.getEmail());
//        user.setId(original.getId());
//        user.setPhone(original.getPhone());
//        user.setName(original.getName());
//        return userDao.save(user);
//    }
}
