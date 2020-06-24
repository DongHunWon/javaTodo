package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userDao.findById(id).get();
    }
}
