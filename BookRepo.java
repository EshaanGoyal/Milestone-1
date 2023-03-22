package com.global.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.global.db.DBConnection;
import com.global.to.*;
public class BookRepo {
	
	Connection connection  = DBConnection.getConnection();
	
	public void insert(String name, String author, int copies, int price) {
		try {
            PreparedStatement statement = connection.prepareStatement("insert into book values (?,?,?,?,?);");
            statement.setString(2, name);
            statement.setString(3, author);
            statement.setInt(4, copies);
            statement.setInt(5, price);
            statement.executeQuery();
        }
        catch (Exception e){
        }
	}
	
	public List<BookTO> list() {
		List<BookTO> books = new ArrayList<BookTO>();
		try {
            PreparedStatement statement = connection.prepareStatement("select * from book;");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String author = resultSet.getString(3);
				String description = resultSet.getString(4);
				int copies = resultSet.getInt(5);
				int price = resultSet.getInt(6);
				BookTO bookTO = new BookTO(name, id, author, description, copies, price);
				books.add(bookTO);	
			}
        }
        catch (Exception e){
        }
		return books;
	}
	
	public void update(String value,String field) {
		try {
            PreparedStatement statement = connection.prepareStatement("insert into book (?) values (?)");
            statement.setString(2, value);
            statement.setString(1, field);
            statement.executeQuery();
        }
        catch (Exception e){
        }
	}
	
	public void remove(int id) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM book WHERE id = (?);");
            statement.setInt(1, id);
            statement.executeQuery();
        }
        catch (Exception e){
        }
	}
}
