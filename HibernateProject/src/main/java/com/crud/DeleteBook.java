package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class DeleteBook {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.u need to create something like session factory
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		
		//2.from session factory -->session
		Session session=factory.openSession();
		
		//3.need to start the transaction 
		Transaction tx= session.getTransaction();
		
		//4.create an object
		Book bookTodelete=session.get(Book.class, 4);
		try
		{
			tx.begin();
			session.delete(bookTodelete);               //calls session.save
			tx.commit();
			
		}
		catch(HibernateException hx)
		{
			hx.printStackTrace();
			tx.rollback();                  //call commit and rollback for the transaction
		}
		session.close();
		
		factory.close();
	}
}
