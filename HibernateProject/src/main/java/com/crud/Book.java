package com.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="book_hibernate")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String bookname;
	String author;
	double price;
	public Book(int id, String bookname, String author,  double price) {
	
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	public Book()
	{
		
	}
	public Book(String bookname, String author, double price) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", price=" + price + "]";
	}
	
	
	
}
