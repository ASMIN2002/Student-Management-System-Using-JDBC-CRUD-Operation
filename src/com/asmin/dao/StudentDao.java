package com.asmin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.asmin.beans.Student;
import com.asmin.main.Main;

// all database work here

public class StudentDao {
	Conn c = new Conn();
	String status;
	Scanner s = new Scanner(System.in);

	//Boiler Plate For checking purpose
	
	public Student checkId(int id) {
		try {
			PreparedStatement ps1 = c.connection.prepareStatement("select * from stu2 where roll=?");
			ps1.setInt(1, id);

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {
				return null;
			} else {
				Student std = new Student();
				return std;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// -- ADD STUDENT
	public String addStudent(int id, String name, String email, String addr) {
		try {
			Student std = checkId(id);
			if (std != null) {
				PreparedStatement ps = c.connection.prepareStatement("insert into stu2 values(?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, addr);

				int count = ps.executeUpdate();
				if (count > 0) {
					status = "\nStudent-Added-Successfully";
				}
			} else {
				status = "\nStudent-Already-Exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// -- SEARCH STUDENT
	public void searchStudent(int id) {

		try {
			Student std = checkId(id);

			if (std == null) {
				PreparedStatement ps = c.connection.prepareStatement("select * from stu2 where roll=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				System.out.println("\nStudent Details");
				System.out.println("- - - - - - - -");
				while (rs.next()) {
					System.out.println("Student Rollno       : " + rs.getInt(1));
					System.out.println("Student Name         : " + rs.getString(2));
					System.out.println("Student Email        : " + rs.getString(3));
					System.out.println("Student Address      : " + rs.getString(4));

				}
			} else {
				System.err.println("Sorry! Student does not exist,\nPlease try again with valid Rollno.");
				new Main();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudent(int id) {
		Student std1 = new Student();

		try {
			Student std = checkId(id);

			if (std == null) {
				PreparedStatement ps = c.connection.prepareStatement("select * from stu2 where roll=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					std1.setSroll(rs.getInt(1));
					std1.setSname(rs.getString(2));
					std1.setSemail(rs.getString(3));
					std1.setSaddr(rs.getString(4));

					System.out.println("\nYour Old Details\n-----------------");
					System.out.println(std1 + "\n");
					System.out.print("Confirm to Update [Yes/No]   : ");
					String choice = s.next();

					String ename = rs.getString(2);
					if (choice.equalsIgnoreCase("yes")) {

						System.err
								.println("Note* If you not providing new details\nyour previous details will be saved");

						System.out.print("Your Old Name     : " + std1.getSname() + "\nEnter New Name    : ");
						s.nextLine();
						String name = s.nextLine();
						if (name == "") {
							name = ename;
						}
						System.out.print("Your Old Email    : " + rs.getString(3) + "\nEnter New Email   : ");
						String email = s.nextLine();
						if (email.equals("")) {
							email = std1.getSemail();
						}
						System.out.print("Your Old Address  : " + rs.getString(4) + "\nEnter New Address : ");
						String addr = s.nextLine();

						if (addr.equals("")) {
							addr = std1.getSaddr();
						}

						PreparedStatement ps1 = c.connection
								.prepareStatement("update stu2 set name=?,email=?,addr=? where roll=?");
						ps1.setString(1, name);
						ps1.setString(2, email);
						ps1.setString(3, addr);
						ps1.setInt(4, id);

						int count = ps1.executeUpdate();
						if (count > 0) {

							System.out.println("\nStudent updated successfully");
						}
					} else if (choice.equalsIgnoreCase("NO")) {
						System.out.println("Your data have safe with us.");
					} else {
						System.err.println("Please Write Yes or No.\nNothing else");
					}
				}
			} else {
				System.err.println("Sorry! Student does not exist,\nPlease try again with valid Rollno.");
				new Main();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAll() {
		try {

			PreparedStatement ps = c.connection.prepareStatement("select * from stu2");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student std = new Student();
				std.setSroll(rs.getInt(1));
				std.setSname(rs.getString(2));
				std.setSemail(rs.getString(3));
				std.setSaddr(rs.getString(4));
				System.out.println(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Student std = checkId(id);
			if (std == null) {
				PreparedStatement ps = c.connection.prepareStatement("delete from stu2 where roll=?");
				ps.setInt(1, id);

				int count = ps.executeUpdate();
				if (count > 0) {
					System.out.println("Student Deletion Successfully");
					;
				}
			} else {
				System.err.println("Sorry! Student does not exist,\nPlease try again with valid Rollno.");
				new Main();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
