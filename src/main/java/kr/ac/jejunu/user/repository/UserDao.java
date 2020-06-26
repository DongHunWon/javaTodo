package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
