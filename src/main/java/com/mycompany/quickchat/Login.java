/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author clement
 */
import java.util.regex.Pattern;


public class Login {

     String userName;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;

    // ---------------- USERNAME CHECK ----------------
    public boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() <= 5;
    }

    // ---------------- PASSWORD CHECK ----------------
    public boolean checkPasswordComplexity(String password) {

    String regex =
            "^(?=.*[A-Z])" +      // capital letter
            "(?=.*\\d)" +         // number
            "(?=.*[@#$%^&+=!])" + // special character
            ".{8,}$";             // length

    return Pattern.matches(regex, password);
}

    // ---------------- CELL NUMBER CHECK ----------------
    /*
     Regex adapted from:
     https://stackoverflow.com/questions/18721688/java-regex-for-phone-number-validation
     */
    public boolean checkCellPhoneNumber(String cellPhone) {

        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellPhone);
    }

    // ---------------- REGISTER USER ----------------
    // User registration functionality added
    public String registerUser(String userName,
                               String password,
                               String cellPhone,
                               String firstName,
                               String lastName) {
    // Username validation implemented
        if (!checkUserName(userName)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    // Password complexity rules added
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.userName = userName;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User successfully registered.";
    }

    // ---------------- LOGIN USER ----------------
    // Login verification completed
    public boolean loginUser(String userName, String password) {
        return this.userName.equals(userName)
                && this.password.equals(password);
    }

    // ---------------- LOGIN STATUS ----------------
    public String returnLoginStatus(boolean status) {

        if (status) {
            return "Welcome " + firstName + ", " + lastName +
                    " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
