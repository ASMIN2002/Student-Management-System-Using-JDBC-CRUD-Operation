package com.asmin.factory;

import com.asmin.controller.StudentController;
import com.asmin.dao.StudentDao;
import com.asmin.services.StudentServices;
import com.asmin.services.StudentServicesImpl;

// for creating objects

public class StudentFactory{
	private static StudentController controller;
	private static StudentDao dao;
	private static StudentServices services;
	public static StudentController getController() {
		controller = new StudentController();
		return controller;
	}
	public static StudentDao getDao() {
		dao=new StudentDao();
		return dao;
	}
	public static StudentServices getServices() {
		services=new StudentServicesImpl();
		return services;
	}

}
