package com.asmin.controller;

import java.util.Scanner;

import com.asmin.beans.Student;
import com.asmin.factory.StudentFactory;
import com.asmin.services.StudentServices;

public class StudentController{
	
	Scanner s = new Scanner(System.in);
	
	Student student = new Student();
	StudentServices services = StudentFactory.getServices();
	
	public void addStudent(){
		System.out.print("Enter Student Rollno    : ");
		student.setSroll(s.nextInt());
		int roll = student.getSroll();
		System.out.print("Enter Student Name      : ");
		s.nextLine();
		student.setSname(s.nextLine());
		String name = student.getSname();
		System.out.print("Enter Student Email     : ");
		student.setSemail(s.nextLine());
		String email = student.getSemail();
		System.out.print("Enter Student Address   : ");
		student.setSaddr(s.nextLine());
		String addr = student.getSaddr();
		
		String status = services.addStudent(roll,name,email,addr);	

		System.out.println(status);
		
	}
	public void searchStudent() {
		System.out.print("Enter Student Rollno    : ");
		student.setSroll(s.nextInt());
		int roll = student.getSroll();
		services.searchStudent(roll);
	}
	public void updateStudent() {
		System.out.print("Enter Student Rollno    : ");
		student.setSroll(s.nextInt());
		int roll = student.getSroll();
		services.updateStudent(roll);
	}
	public void getAll()
	{
		services.getAllStudent();
	}
	public void delete() {
		System.out.print("Enter Student Rollno    : ");
		student.setSroll(s.nextInt());
		int roll = student.getSroll();
		services.deleteStudent(roll);
	}
}
