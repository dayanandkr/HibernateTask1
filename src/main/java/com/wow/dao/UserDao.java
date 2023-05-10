package com.wow.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.wow.model.User;


public class UserDao {
	public  void save(Session s) {
		try {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter User name");
		String name=sc.nextLine();
		//sc.next();
		System.out.println("Please enter User nationality");
		String nationality=sc.nextLine();
		
		User user=new User(name, nationality);
		Transaction tx=s.beginTransaction();
		s.save(user);
		tx.commit();
		System.out.println("User added Succussfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fetchAllUser(Session s){
		try {
		String query="from User";
		Query q= s.createQuery(query);
		List<User>  list=q.list();
		if(list !=null) {
		for(User users :list) {
			System.out.println(users.getId()+" : "+ users.getName()+" : "+users.getNationality() );
		}
		}else {
			System.out.println("No record found");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fetchUserById(Session s) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter user Id");
		try{
			int id=sc.nextInt();
		
		User user=s.get(User.class, id);
		if(user != null) {
		System.out.println(user.getId()+" : "+user.getName()+" : "+user.getNationality());
		}else {
			System.out.println("User not exist with Id :"+id);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void delete(Session s) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter user id");
		try {
		int user_id = sc.nextInt();
		Transaction tx=s.beginTransaction();
		User user=s.get(User.class, user_id);
		if(user !=null) {
		Query q1=s.createQuery("delete from User where id=:id");
		q1.setParameter("id", user_id);
		int r=q1.executeUpdate();
		tx.commit();
		System.out.println("Deleted");
		System.out.println(r);
		}else {
			System.out.println("User not exist with Id :"+user_id);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Session s) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter user id");
		try {
		int id = sc.nextInt();
		User user=s.get(User.class, id);
		if(user != null) {
			System.out.println("please enter User name");
			String name=sc.nextLine();
			name=sc.nextLine();
			System.out.println("Please enter User nationality");
			String nationality=sc.nextLine();
			Transaction tx=s.beginTransaction();
		Query q2=s.createQuery("update User set name=:n, nationality=:na where id=:id");
		q2.setParameter("n", name);
		q2.setParameter("na", nationality);
		q2.setParameter("id", id);
		int r=q2.executeUpdate();
		System.out.println(r+" Oject update");
		tx.commit();
		}else {
			System.out.println("User not exist with Id :"+id);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
