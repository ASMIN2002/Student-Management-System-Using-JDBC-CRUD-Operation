package com.asmin.main;

import java.util.Scanner;

import com.asmin.controller.StudentController;
import com.asmin.factory.StudentFactory;

public class Main {

	StudentController controller; 
	public Main(){
		    Scanner s = new Scanner(System.in);
			System.out.println("\n1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Update Student");
			System.out.println("4. Get All Students");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit\n");
			System.out.print("Enter Your Choice   : ");
			int choice = s.nextInt();
			System.out.println();

			controller= StudentFactory.getController();
			switch (choice) {
			case 1:
				System.out.println("Add-Student-Here");
				System.out.println("= = = = = = = = =\n");
				controller.addStudent();
				new Main();
				break;
			case 2:
				System.out.println("Search-Student-Here");
				System.out.println("= = = = = = = = = =\n");
				controller.searchStudent();
				new Main();
				break;
			case 3:
				System.out.println("Update-Student-Here");
				System.out.println("= = = = = = = = = =\n");
				controller.updateStudent();
				new Main();
				break;
			case 4:	
				System.out.println("Get-All-Students");
				System.out.println("= = = = = = = = =\n");
				controller.getAll();
				new Main();
				break;
			case 5:				
				System.out.println("Delete-Student-Here");
				System.out.println("= = = = = = = = = =\n");
				controller.delete();
				new Main();
				break;
			case 6:
				System.out.println("\tThank You !Have a good day.");
				System.exit(0);
				break;
			default:
				System.out.println("Please Choose Number In Between 1 to 6");
				new Main();
				break;
			}
			s.close();
		}
	

	public static void main(String[] args) {
		System.out.println("+++STUDENT MANAGEMENT SYSTEM+++");
		System.out.println("++++++++++++ WELCOME ++++++++++");
		new Main();
	}
}

