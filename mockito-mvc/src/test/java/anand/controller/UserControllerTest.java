package anand.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import anand.entity.User;
import anand.service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        User user1 = new User();
        user1.setId(1L);
        user1.setName("John Doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Jane Doe");
        user2.setEmail("jane@example.com");

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        // Act
        String viewName = userController.getAllUsers(model);

        // Assert
        verify(model, times(1)).addAttribute("users", users);
        assertEquals("userList", viewName);
    }

    @Test
    void testGetUserById() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");

        when(userService.getUserById(1L)).thenReturn(user);

        // Act
        String viewName = userController.getUserById(1L, model);

        // Assert
        verify(model, times(1)).addAttribute("user", user);
        assertEquals("userDetail", viewName);
    }

    @Test
    void testSaveUser() {
        // Arrange
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        when(userService.saveUser(user)).thenReturn(user);

        // Act
        String viewName = userController.saveUser(user);

        // Assert
        verify(userService, times(1)).saveUser(user);
        assertEquals("redirect:/users", viewName);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        String viewName = userController.deleteUser(userId);

        // Assert
        verify(userService, times(1)).deleteUserById(userId);
        assertEquals("redirect:/users", viewName);
    }
}