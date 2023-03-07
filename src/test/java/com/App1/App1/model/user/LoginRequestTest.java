package com.App1.App1.model.user;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LoginRequestTest {
    @Test
    void getUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("CanhHoang");
        assertEquals("CanhHoang",loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("54321");
        assertEquals("54321",loginRequest.getPassword());
    }

    @Test
    void setUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("CanhHoang");
        assertEquals("CanhHoang",loginRequest.getUsername());
    }

    @Test
    void setPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("54321");
        assertEquals("54321",loginRequest.getPassword());
    }
    @Test
    void testLoginRequestConstructor() {
        LoginRequest loginRequest = new LoginRequest("CanhHoang","54321");
        assertEquals("CanhHoang",loginRequest.getUsername());
        assertEquals("54321",loginRequest.getPassword());
    }
}
