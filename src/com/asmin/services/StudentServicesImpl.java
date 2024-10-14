package com.asmin.services;

import com.asmin.dao.StudentDao;
import com.asmin.factory.StudentFactory;

// then make an implemented class for that interface

public class StudentServicesImpl implements StudentServices{

	StudentDao dao = StudentFactory.getDao();
	@Override
	public String addStudent(int id,String name,String email,String addr) {
		String status = dao.addStudent(id, name, email, addr);
		return status;
	}
	@Override
	public void searchStudent(int id) {
		dao.searchStudent(id);
	}
	@Override
	public void updateStudent(int id) {
		dao.updateStudent(id);
	}
	@Override
	public void getAllStudent() {
		dao.getAll();
	}
	@Override
	public void deleteStudent(int id) {
		dao.delete(id);		
	}
}
