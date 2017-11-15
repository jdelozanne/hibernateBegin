/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatebegin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author julia
 */
public class Helper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Message.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Message tempMes = new Message(0, "what you hear is not a test");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the message...");
			session.save(tempMes);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
	    }
    }   
}
