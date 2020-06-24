package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Integer> {
}
