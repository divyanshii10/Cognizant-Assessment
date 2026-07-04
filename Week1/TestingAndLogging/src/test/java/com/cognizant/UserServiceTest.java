package com.cognizant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testGetUserInfo_Stubbing() {
        // Arrange (Stubbing)
        when(userRepository.getUserDetails(101)).thenReturn("John Doe");

        // Act
        String result = userService.getUserInfo(101);

        // Assert
        assertEquals("John Doe", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testRegisterUser_VerifyingInteraction() {
        // Act
        userService.registerUser(102, "Alice Smith");

        // Assert (Verifying interaction)
        verify(userRepository, times(1)).saveUser(102, "Alice Smith");
    }
}
