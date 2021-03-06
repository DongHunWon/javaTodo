package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.Todo;
import kr.ac.jejunu.user.repository.TodoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public List<Todo> getList() {
        return todoDao.findAll();
    }

    @PostMapping("/save")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoDao.save(todo);
    }

    @PostMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoDao.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTodo(@PathVariable("id") Integer id){
        todoDao.deleteById(id);
        return !todoDao.findById(id).isPresent();
    }
}
