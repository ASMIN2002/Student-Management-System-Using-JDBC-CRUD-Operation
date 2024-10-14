package com.asmin.services;

// make an interface

public interface StudentServices{
	public String addStudent(int id,String name,String email,String addr);
	public void searchStudent(int id);
	public void updateStudent(int id);
	public void getAllStudent();
	public void deleteStudent(int id);
}
