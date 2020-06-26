package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.model.Board;
import kr.ac.jejunu.user.model.Todo;
import kr.ac.jejunu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardDao extends JpaRepository<Board, Integer> {
    Optional<Board> findByEmail(String email);
}
