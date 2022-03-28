package com.crud;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.factory.HibernateSessionFactory;

public class AddBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.u need to create something like session factory
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		
		//2.from session factory -->session
		Session session=factory.openSession();
		
		//3.need to start the transaction 
		Transaction tx= session.getTransaction();
		
		//4.create an object
		Book book=new Book("prince","amruta",300.2);
		try
		{
			tx.begin();
			session.save(book);                //calls session.save
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
