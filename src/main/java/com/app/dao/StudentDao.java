package com.app.dao;

import com.app.model.Student;

import java.util.List;

public interface StudentDao {
	
	void addStudent(Student student);

	void deleteStudent(int studentId);

	void updateStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int studentId);
}
