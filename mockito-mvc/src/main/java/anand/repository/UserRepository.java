package anand.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import anand.entity.User;

@Repository
public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
