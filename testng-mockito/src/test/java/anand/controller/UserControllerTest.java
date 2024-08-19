package anand.controller;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;

import anand.entity.User;
import anand.service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser() {
        User user = new User(1L, "anand", "patel", "anand@gmail.com");
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserById(1L);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getFirstName(), "anand");
        assertEquals(response.getBody().getLastName(), "patel");
        assertEquals(response.getBody().getEmail(), "anand@gmail.com");
    }
}
