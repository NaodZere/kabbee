package OnlineBankingSystem.TesfaSolutions.controllerTest;

import OnlineBankingSystem.TesfaSolutions.controller.AdminController;
import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)

public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByUsername_WhenUserExists(){
        String username = "testUsername";
        User mockUser = new User();
        mockUser.setUsername(username);
        when(userService.findByUserName(username)).thenReturn(Optional.of(mockUser));
        ResponseEntity<User> response = adminController.findByUsername(username);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());

        verify(userService, times(1)).findByUserName(username);

    }

    @Test
    public void testDeleteUser() {
        Integer userId = 1;

        adminController.deleteUser(userId);

        verify(userService, times(1)).deleteUser(userId);
    }


    @Test
    public void testUpdateUser() {
        int userId = 1;
        User updatedUser = new User();

        when(userService.updateUser(userId, updatedUser)).thenReturn(new ResponseEntity<>(updatedUser, HttpStatus.OK));

        ResponseEntity<User> response = adminController.updateUser(userId, updatedUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());

        verify(userService, times(1)).updateUser(userId, updatedUser);
    }

    @Test
    public void testFindAllUsers() {
        List<User> userList = new ArrayList<>();
        // Add mock users to the list

        when(userService.findAllUsers()).thenReturn(userList);

        ResponseEntity<List<User>> response = adminController.findAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());

        verify(userService, times(1)).findAllUsers();
    }
}
