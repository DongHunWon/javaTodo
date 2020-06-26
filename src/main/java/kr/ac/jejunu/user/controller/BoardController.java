package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.Board;
import kr.ac.jejunu.user.model.Todo;
import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.BoardDao;
import kr.ac.jejunu.user.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardDao boardDao;

    @GetMapping("/list")
    public List<Board> getlist() {
        return boardDao.findAll();
    }
}
