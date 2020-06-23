package com.cognixia.jump.doaImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.cognixia.jump.doa.StudentDAO;
import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Student;

public class StudentDAOImp implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {

		
		
		
		try {
			
           Connection conn = ConnectionManager.getConnection();
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from student");
			
			
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Student getStudentById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Student student) {
		
		// insert into student values(id, fname, lname, gender, dob, credits, addr_id, dept_id);
		
		// grab the id for the department
		int deptId = student.getDept().getId();
		
		// grab the id for the address
		int addrId = student.getAddress().getId();
		
		// add in your values to statement
		
		
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
