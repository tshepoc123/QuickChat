package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    // USERNAME TESTS
    @Test
    public void testCorrectUsername() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testIncorrectUsername() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    // PASSWORD TESTS
    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // CELL NUMBER TESTS
    @Test
    public void testValidCellNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testInvalidCellNumber() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // LOGIN TESTS
    @Test
    public void testLoginSuccess() {

        login.registerUser("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith");

        assertTrue(login.loginUser("kyl_1","Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {

        login.registerUser("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith");

        assertFalse(login.loginUser("wrong","wrong"));
    }
}