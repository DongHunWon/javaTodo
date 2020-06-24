package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
