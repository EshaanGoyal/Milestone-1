package com.global.service;

import com.global.repository.*;
import java.util.*;
import com.global.to.*;

public class BookService {
	Scanner sc = new Scanner(System.in);
	BookRepo repo = new BookRepo();

	public void adminService() {
		System.out.println("Enter your choice");
		System.out.println("1. Insert Book Detail");
		System.out.println("2. List all Books");
		System.out.println("3. Update Book");
		System.out.println("4. Remove Book");

		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			insert();
			break;
		case 2:
			list();
			break;
		case 3:
			update();
			break;
		case 4:
			remove();
			break;
	}}

	public void userService() {
		System.out.println("Enter your choice");
		System.out.println("1. Search Book");
		System.out.println("2. List all Books");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				//search();
				break;
			case 2:
				list();
				break;
		}
	}

	public void insert() {
		System.out.println("Enter Book Details");
		System.out.println("Enter Book Name:");
		String name = sc.nextLine();
		System.out.println("Enter Book Author:");
		String author = sc.nextLine();
		System.out.println("Enter Copies Sold:");
		int copies = sc.nextInt();
		System.out.println("Enter Price:");
		int price = sc.nextInt();
		repo.insert(name, author, copies, price);
	}

	public void list() {
		List<BookTO> books = new ArrayList<BookTO>();
		books = repo.list();
		for (BookTO book : books) {
			System.out.println(book);
		}
	}

	public void update() {
		System.out.println("Enter Book Name to Update");
		String newValue = sc.nextLine();
		repo.update(newValue, "name");
	}

	public void remove() {
		System.out.println("Enter ID of Book to remove");
		int id = sc.nextInt();
		repo.remove(id);
	}

}
