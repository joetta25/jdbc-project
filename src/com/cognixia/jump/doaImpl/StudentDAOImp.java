package com.cognixia.jump.doaImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.doa.StudentDAO;
import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Student;

public class StudentDAOImp implements StudentDAO {
	
	
	private Connection connection;
	
	private Statement statement;

	@Override
	public  List<Student> getAllStudents() {
		
		String query = "SELECT * FROM student";
		
		List<Student> list = new ArrayList<Student>();
		Student student = null;
		ResultSet rs = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			statement = connection.createStatement();
			
			rs = statement.executeQuery(query);
			
			while (rs.next()) {
				
				
				
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String gender = rs.getString(4);
				Date dob = rs.getDate(5);
				int credits = rs.getInt(6);
				int studentAddress = rs.getInt(7);
				int studentDept = rs.getInt(8);
				
				
				student = new Student(id, firstName, lastName, gender, dob, credits, studentAddress, studentDept);
				
				list.add(student);
				
				
			}
			
			rs.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return list;
	}

	@Override
	public Student getStudentById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Student student) {
		
		 String query = "insert into student (id, first_name, last_name, gender, date_of_birth, credits, addr_id, dept_id)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)"; 
		
		try {
			
			int deptId = student.getDept().getId();
			int addrId = student.getAddress().getId();
			connection = ConnectionManager.getConnection();
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			preparedStmt.setString(2,"Joetta");
			preparedStmt.setString(3,"Hall");
			preparedStmt.setString(4,"F");
			preparedStmt.setDouble(5,1995-01-07);
			preparedStmt.setInt(6,30);
			preparedStmt.setInt(7,addrId);
			preparedStmt.setInt(8,deptId);
			
			
		      // execute the preparedstatement
		      preparedStmt.execute();
		 
		      connection.close();
			
		} catch (SQLException e) {
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		}
		
		
		
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
