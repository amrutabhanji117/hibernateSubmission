package com.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.HibernateSessionFactory;

public class ShowAllBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		
		Session session = factory.openSession();
		//WE DONT NEED TRANSACTION IF WE JUST WANT TO READ THE DATA
		//SQL		vs 		HQL (OO way to write quaries)
		List<Book> books=session
				.createQuery("select b from Book b", Book.class)
				.getResultList();
		for(Book book: books) {
			System.out.println(book);
		}
		
		
		session.close();
		factory.close();
	}

}
