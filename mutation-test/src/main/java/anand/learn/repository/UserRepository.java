package anand.learn.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import anand.learn.entity.User;

@Repository
public class UserRepository {
	private static List<User> users;
	static {
		users = new ArrayList<User>();
		users.add(new User(11,"anand"));
		users.add(new User(12,"kumar"));
		users.add(new User(13,"patel"));
		users.add(new User(14,"uday"));
		users.add(new User(15,"raj"));
	}

	public List<User> getAllUsers() {
		return users;
	}

}
