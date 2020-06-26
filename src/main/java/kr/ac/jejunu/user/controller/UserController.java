package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserDao userDao;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userDao.save(user);
    }
}
