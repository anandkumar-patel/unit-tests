package anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anand.entity.User;
import anand.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User existingUser = user.get();
			existingUser.setFirstName(userDetails.getFirstName());
			existingUser.setLastName(userDetails.getLastName());
			existingUser.setEmail(userDetails.getEmail());
			return userRepository.save(existingUser);
		}
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
