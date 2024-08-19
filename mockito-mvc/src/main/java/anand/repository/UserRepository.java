package anand.repository;

import java.util.List;

import anand.entity.User;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
