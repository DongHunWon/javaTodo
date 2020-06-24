package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.Todo;
import kr.ac.jejunu.user.repository.TodoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoDao todoDao;

    @GetMapping("/{id}")
    public Todo get(@PathVariable("id") Integer id) {
        Todo todo = null;
        Optional<Todo> optionalUser = todoDao.findById(id);
        if (optionalUser.isPresent()) {
            todo = optionalUser.get();
        }

        return todo;
    }

    @GetMapping("/")
    public List<Todo> getList() {
        return todoDao.findAll();
    }
}
