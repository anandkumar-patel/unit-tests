package anand.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import anand.entity.User;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        User user = new User(1L,"John", "Doe", "john.doe@example.com");
        user = entityManager.persistAndFlush(user);

        Optional<User> foundUser = userRepository.findById(user.getId());

        assertTrue(foundUser.isPresent());
        assertEquals(user.getFirstName(), foundUser.get().getFirstName());
        assertEquals(user.getLastName(), foundUser.get().getLastName());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }

    // Add more test methods for other repository methods
}
