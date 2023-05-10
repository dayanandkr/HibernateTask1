package com.wow;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wow.dao.UserDao;


public class App 
{
	
    public static void main( String[] args )
    {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        
       UserDao userDao=new UserDao();
       //User user= app.save();
       
       Session s=factory.openSession();
       
       //Save Data to Database
       while(true) {
       System.out.println("Input your choice from the following menu:");
       System.out.println("Please press 1 for Add User");
       System.out.println("Please press 2 for View all User");
       System.out.println("Please press 3 for View User by Id");
       System.out.println("Please press 4 for Update User");
       System.out.println("Please press 5 for Delete User");
       System.out.println("Please press 6 for Exit");
       Scanner sc=new Scanner(System.in);
       int choice=sc.nextInt();
       switch(choice) {
       case 1: userDao.save(s);
       		   break;
       case 2: userDao.fetchAllUser(s);
       			break;
       case 3: userDao.fetchUserById(s);
				break;
       case 4: userDao.update(s);
				break;
       case 5: userDao.delete(s);
				break;
       case 6: 	s.close();
       			factory.close();
       			System.exit(0);
       			
       default:
           System.out.println("Invalid choice");
    	   
    }
       }
    
      
        
    }
}
