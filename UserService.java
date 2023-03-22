package com.global.service;
import com.global.repository.*;
import java.util.Scanner;

public class UserService {
    public void login(){
        UserRepo userRepo = new UserRepo();
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        userRepo.login(username, password);
        /*System.out.println(status);
        if (status.equals("admin")) {
        	bookService.adminService();
        	return 0;
        }
        else if (status.equals("user")) {
            bookService.userService();
        	return 0;
        }
        else{
            return 1;
        }*/
    }
    
    public void register(){
        Scanner sc = new Scanner(System.in);
        UserRepo repo = new UserRepo();
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("Enter First Name: ");
        String firstname = sc.nextLine();
        System.out.println("Enter Last Name: ");
        String lastname = sc.nextLine();
        System.out.println("Enter Role: ");
        String role = sc.nextLine();
        Boolean status = repo.register(username, password, firstname, lastname, role);
        if (status) {
        	System.out.println("Registration Successful");
        }
        else {
        	System.out.println("Registration Failed");
        }
    }
}
