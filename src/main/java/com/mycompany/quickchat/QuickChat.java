/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

/**
 *
 * @author clement
 */
import java.util.Scanner;


public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== Registration ===");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String userName = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Phone (+27XXXXXXXXX): ");
        String cellPhone = input.nextLine();

        String registrationMessage =
                login.registerUser(userName, password,
                        cellPhone, firstName, lastName);

        System.out.println(registrationMessage);

        if (!registrationMessage.equals("User successfully registered.")) {
            return;
        }

        System.out.println("\n=== Login ===");

        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        boolean loginStatus =
                login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus(loginStatus));
    }
}
